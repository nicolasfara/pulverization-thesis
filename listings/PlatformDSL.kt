val platform = pulverizationPlatform(
    config.getDeviceConfiguration("device-1")
) {
    behaviourLogic(
        BehaviourComponent(), ::behaviourLogic
    )
    stateLogic(StateComponent(), ::stateLogic)
    communicationLogic(
        CommunicationComponent(), ::communicationLogic
    )
    actuatorsLogic(
        ActuatorsComponent(), ::actuatorsLogic
    )
    sensorsLogic(SensorsComponent(), ::sensorsLogic)

    withPlatform { RabbitmqCommunicator() }
    withRemotePlace { defaultRabbitMQRemotePlace() }

    withContxt {
        configFilePath("config/.pulverization.env")
    }
}
