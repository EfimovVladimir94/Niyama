plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:api"))
                implementation(project(":common:profile:api"))
                implementation(project(":common:core"))
                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}