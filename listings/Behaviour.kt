data class BehaviourOutput<S, E, A, O>(
    val newState: S,
    val newExport: E,
    val actuations: A,
    val outcome: O,
)

interface Behaviour<S, E, W, A, O> :
    PulverizedComponent {
    override val componentType = BehaviourComponent
    operator fun invoke(
        state: S, export: List<E>, sensedValues: W
    ): BehaviourOutput<S, E, A, O>
}
