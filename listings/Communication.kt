interface Communication<P : Any> : PulverizedComponent {
    override val componentType: PulverizedComponentType
        get() = CommunicationComponent

    suspend fun send(payload: P)

    fun receive(): Flow<P>
}
