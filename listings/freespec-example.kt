class BasePulverizationConfigTest : FreeSpec({
    "The configuration DSL" - {
    "should configure a logical device" {
        val config = pulverizationConfig {
            logicalDevice("device-1") {
                StateComponent deployableOn Cloud
                BehaviourComponent deployableOn Edge
            }
            logicalDevice("device-2") { }
        }
        config.devicesConfig.size shouldBe 2
        config.getDeviceConfiguration("device-1")?.let {
            it.deviceName shouldBe "device-1"
            it.components.size shouldBe 2
            it.deploymentUnits.size shouldBe 2
        }
    }}
})