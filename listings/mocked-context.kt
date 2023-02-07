class ActuatorsContainerTest : FreeSpec(), KoinTest {
    override fun getKoin(): Koin = koinApplication {
        module {
            single {
                object : Context {
                    override val deviceID = "test"
                }
            }
        }
    }.koin

    // Tests
}