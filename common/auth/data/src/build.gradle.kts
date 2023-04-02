plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourseSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
            }
        }
    }
}