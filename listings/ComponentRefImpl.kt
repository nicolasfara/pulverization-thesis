internal class ComponentRefImpl<S : Any>(
    private val serializer: KSerializer<S>,
    private val binding: Binding,
    private val communicator: Communicator,
) : ComponentRef<S>, KoinComponent {
    private val remotePlaceProvider by inject()
    private var last: S? = null

    suspend fun setup() {
        communicator.setup(
            binding, remotePlaceProvider[binding.second]
        )
    }
    suspend fun sendToComponent(message: S) {
        communicator.fireMessage(message.serialize())
    }
    suspend fun receiveFromComponent(): Flow<S> {
        return communicator.receiveMessage()
            .map { it.deserialize() }
            .onEach { last = it }
    }
    suspend fun receiveLastFromComponent(): S? = last
}