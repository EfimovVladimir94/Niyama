plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:profile:api"))
                implementation(project(":common:core"))
            }
        }
    }
}