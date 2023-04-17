package com.example.niyama.android

import PlatformSDK
import android.app.Application
import platform.PlatformConfiguration

class NiyamaApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initPlatformSdk()
    }
}

fun NiyamaApp.initPlatformSdk() = PlatformSDK.init(
    configuration = PlatformConfiguration(androidContext = applicationContext)
)