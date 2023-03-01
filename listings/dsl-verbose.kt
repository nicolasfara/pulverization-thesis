val platform = pulverizationPlatform<StateOps, Comm, SensorsPayload, ActuatorsPayload, Unit>(
    config.getDeviceConfiguration("device-1")
) {
    behaviourLogic(
        BehaviourComponent(), ::behaviourLogic
    )
    stateLogic(
        StateComponent(), ::stateLogic
    )
    communicationLogic(
        CommunicationComponent(), ::commLogic
    )
    actuatorsLogic(
        ActuatorsComponent(), ::actuatorsLogic
    )
    sensorsLogic(
        SensorsComponent(), ::sensorsLogic
    )
}