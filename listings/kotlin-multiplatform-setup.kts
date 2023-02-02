plugins {
    kotlin("multiplatform") version "1.8.0"
}

kotlin {
    jvm()
    android()

    ios()
    watchos()

    linuxX64()
    linuxArm64()
    mingwX64()
    macosX64()
    macosArm64()
}
