pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Niyama"
include(":androidApp")
include(":common:auth:api")
include(":common:auth:presentation")
include(":common:auth:data")
include(":common:core")
include(":common:umbrella-compose")
include(":common:umbrella-ios")