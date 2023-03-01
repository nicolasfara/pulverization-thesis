internal class ComponentRefImpl<S : Any>(
    private val serializer: KSerializer<S>,
    private val binding: Pair<..., ...>,
    private val communicator: Communicator,
) : ComponentRef<S>, KoinComponent {
    private val remotePlaceProvider by inject()
    private var last: S? = null

    companion object {
        inline operator fun <reified S : Any> invoke(
            binding: Pair<..., ...>
            communicator: Communicator,
        ): ComponentRefImpl<S> = ComponentRefImpl(
            serializer(), binding, communicator
        )
    }
    suspend fun setup() {
        communicator.setup(
            binding, remotePlaceProvider[binding.second]
        )
    }
    suspend fun sendToComponent(message: S) {
        communicator.fireMessage(
            Json.encodeToString(serializer, message)
                .encodeToByteArray()
        )
    }
    suspend fun receiveFromComponent(): Flow<S> {
        return communicator.receiveMessage()
            .map { Json.decodeFromString(
                serializer, it.decodeToString()
            )}.onEach { last = it }
    }
    suspend fun receiveLastFromComponent(): S? = last
}