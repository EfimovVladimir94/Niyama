plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin {
    cocoapods {
        summary = "Nyiama iOS SDK"
        homepage = "https://github.com/EfimovVladimir94/Niyama"
        ios.deploymentTarget = "14.1"

        framework {
            transitiveExport = false
            baseName = "SharedSDK"
            export(project(":common:core"))
            export(project(":common:core-utils"))
            export(project(":common:auth:api"))
            export(project(":common:auth:presentation"))
            export(project(":common:profile:api"))
            export(project(":common:umbrella-core"))
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:api"))
                implementation(project(":common:auth:presentation"))
                implementation(project(":common:profile:api"))
                implementation(project(":common:umbrella-core"))
            }
        }
        iosMain {
            dependencies {
                api(project(":common:core"))
                api(project(":common:core-utils"))
                api(project(":common:auth:api"))
                api(project(":common:auth:presentation"))
                api(project(":common:profile:api"))
                api(project(":common:umbrella-core"))
            }
        }
    }
}