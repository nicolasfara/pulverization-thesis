data class BehaviourOutput<S : Any, E : Any, A : Any, O : Any>(
    val newState: S,
    val newExport: E,
    val actuations: A,
    val outcome: O,
)

interface Behaviour<S : Any, E : Any, W : Any, A : Any, O : Any> : PulverizedComponent {
    override val componentType: PulverizedComponentType
        get() = BehaviourComponent

    operator fun invoke(state: S, export: List<E>, sensedValues: W): BehaviourOutput<S, E, A, O>
}
