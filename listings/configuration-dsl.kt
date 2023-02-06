val config = pulverizationConfig {
    logicalDevice("device-1") {
        BehaviourComponent and StateComponent deployableOn Cloud
        StateComponent deployableOn Cloud
        CommunicationComponent deployableOn Edge
        SensorsComponent deployableOn Device
    }

    logicalDevice("device-2") {
        BehaviourComponent and StateComponent and CommunicationComponent deployableOn Device
    }

    logicalDevice("device-3") {
        BehaviourComponent deployableOn Cloud
        CommunicationComponent deployableOn Edge
        SensorsComponent deployableOn Device
    }

    deviceLinks {
        "device-1" linkedWith "device-2"
        "device-1" linkedWith "device-3"
    }
}