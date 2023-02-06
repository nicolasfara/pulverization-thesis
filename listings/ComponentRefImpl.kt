internal class ComponentRefImpl<S : Any>(
    private val serializer: KSerializer<S>,
    private val binding: Pair<PulverizedComponentType, PulverizedComponentType>,
    private val communicator: Communicator,
) : ComponentRef<S>, KoinComponent {

    override fun getKoin(): Koin = PulverizationKoinModule.koinApp?.koin ?: error("No Koin app defined")

    private val remotePlaceProvider: RemotePlaceProvider by inject()
    private var last: S? = null

    companion object {
        inline operator fun <reified S : Any> invoke(
            binding: Pair<PulverizedComponentType, PulverizedComponentType>,
            communicator: Communicator,
        ): ComponentRefImpl<S> = ComponentRefImpl(serializer(), binding, communicator)
    }

    override suspend fun setup() {
        communicator.setup(binding, remotePlaceProvider[binding.second])
    }

    override suspend fun sendToComponent(message: S) {
        communicator.fireMessage(Json.encodeToString(serializer, message).encodeToByteArray())
    }

    override suspend fun receiveFromComponent(): Flow<S> {
        return communicator.receiveMessage().map { Json.decodeFromString(serializer, it.decodeToString()) }
            .onEach { last = it }
    }

    override suspend fun receiveLastFromComponent(): S? = last
}