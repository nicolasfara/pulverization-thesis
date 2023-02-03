interface Communicator {

    suspend fun setup(binding: Binding, remotePlace: RemotePlace?)

    suspend fun finalize()

    suspend fun fireMessage(message: ByteArray)

    fun receiveMessage(): Flow<ByteArray>
}
