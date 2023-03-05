plugins {
    kotlin("multiplatform") version "1.8.10"
}

kotlin {
    jvm()
    android()

    ios()
    watchos()
    tvos()

    linuxX64(); linuxArm64()
    mingwX64();
    macosX64(); macosArm64()
}
