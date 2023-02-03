interface State<S : Any> : PulverizedComponent {
    override val componentType: PulverizedComponentType
        get() = StateComponent

    fun get(): S

    fun update(newState: S): S
}