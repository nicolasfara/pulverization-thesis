internal class NoOpComponentRef<S : Any> :
    ComponentRef<S> {
    override suspend fun sendToComponent(message: S) {}
    override suspend fun receiveFromComponent(): Flow<S>
        = emptyFlow()
    override suspend fun receiveLastFromComponent(): S?
        = null
}