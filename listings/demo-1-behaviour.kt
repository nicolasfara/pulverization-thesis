class SoilMoistureBehaviour : Behaviour<StateOps, Unit, Double, Boolean, Unit> {
    companion object {
        private const val TARGET_MOISTURE = 30.0
    }

    override fun invoke(
        state: StateOps,
        export: List<Unit>,
        sensedValues: Double,
    ): BehaviourOutput<StateOps, Unit, Boolean, Unit> {
        val action = sensedValues < TARGET_MOISTURE
        return BehaviourOutput(MoistureState(sensedValues), Unit, action, Unit)
    }
}
