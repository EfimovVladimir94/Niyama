plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(Dependencies.Kotlin.Serialization.serialization)
                api(Dependencies.Kotlin.Coroutines.core)
                api(Dependencies.Ktor.core)
                api(Dependencies.Kodein.core)
                implementation(Dependencies.Ktor.json)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.contentNegotiation)
                implementation(Dependencies.Ktor.kotlin_json)
                implementation(Dependencies.Ktor.logging)
            }
        }
        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
            }
        }
        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
            }
        }
    }
}