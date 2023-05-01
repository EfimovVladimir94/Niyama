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
include(":common:auth:compose")
include(":common:core")
include(":common:umbrella-compose")
include(":common:umbrella-ios")
include(":common:profile:api")
include(":common:profile:presentation")
include(":common:profile:data")
include(":common:profile:compose")
include(":common:core-compose")
include(":common:core-utils")
include(":common:umbrella-core")
