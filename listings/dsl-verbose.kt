val platform = pulverizationPlatform<StateOps, Comm,
    SensorsPayload, ActuatorsPayload, Unit>(
    config.getDeviceConfiguration("device-1")
) {
    behaviourLogic(BehaviourComponent(), ::bhvLogi)
    stateLogic(StateComponent(), ::stateLogic)
    communicationLogic(CommComponent(), ::commLogic)
    actuatorsLogic(ActuatorsComponent(), ::actLogic)
    sensorsLogic(SensorsComponent(), ::sensLogic)
}