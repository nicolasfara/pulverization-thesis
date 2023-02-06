companion object {
    fun <S, C, SS, AS, R> PulverizationPlatformScope<S, C, SS, AS, R>.behaviourLogic(
        behaviour: Behaviour<S, C, SS, AS, R>, logic: BehaviourLogicType<S, C, SS, AS, R>,
    ) where S : Any, C : Any, SS : Any, AS : Any, R : Any {
        configuredComponents += BehaviourComponent
        behaviourComponent = behaviour
        behaviourLogic = logic
    }

    // Other methos omitted for brevity
}