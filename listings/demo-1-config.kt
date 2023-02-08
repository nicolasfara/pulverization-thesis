val configuration = pulverizationConfig {
    logicalDevice("moisture-device") {
        SensorsComponent deployableOn Device
        ActuatorsComponent deployableOn Device
        StateComponent and BehaviourComponent deployableOn Edge
    }
}