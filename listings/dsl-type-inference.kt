companion object {
    fun <S, C, SS, AS, R> PulverizationPlatformScope<S, C, SS, AS, R>.behaviourLogic(
        behaviour: Behaviour<S, C, SS, AS, R>, logic: BehaviourLogicType<S, C, SS, AS, R>,
    ) where S : Any, C : Any, SS : Any, AS : Any, R : Any {
        configuredComponents += BehaviourComponent
        behaviourComponent = behaviour
        behaviourLogic = logic
    }

    fun <S, C, SS, AS, R> PulverizationPlatformScope<S, C, SS, AS, R>.communicationLogic(
        communication: Communication<C>, logic: CommunicationLogicType<C>,
    ) where S : Any, C : Any, SS : Any, AS : Any, R : Any {
        configuredComponents += CommunicationComponent
        communicationComponent = communication
        communicationLogic = logic
    }

    fun <S, C, SS, AS, R> PulverizationPlatformScope<S, C, SS, AS, R>.actuatorsLogic(
        actuators: ActuatorsContainer, logic: ActuatorsLogicType<AS>,
    ) where S : Any, C : Any, SS : Any, AS : Any, R : Any {
        configuredComponents += ActuatorsComponent
        actuatorsComponent = actuators
        actuatorsLogic = logic
    }

    fun <S, C, SS, AS, R> PulverizationPlatformScope<S, C, SS, AS, R>.sensorsLogic(
        sensors: SensorsContainer, logic: SensorsLogicType<SS>,
    ) where S : Any, C : Any, SS : Any, AS : Any, R : Any {
        configuredComponents += SensorsComponent
        sensorsComponent = sensors
        sensorsLogic = logic
    }
    fun <S, C, SS, AS, R> PulverizationPlatformScope<S, C, SS, AS, R>.stateLogic(
        state: State<S>, logic: StateLogicType<S>,
    ) where S : Any, C : Any, SS : Any, AS : Any, R : Any {
        configuredComponents += StateComponent
        stateComponent = state
        stateLogic = logic
    }
}