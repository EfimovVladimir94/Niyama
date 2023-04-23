plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.niyama.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.niyama.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:profile:api"))
    implementation(project(":common:umbrella-compose"))
    implementation(Dependencies.Android.composeActivity)
}