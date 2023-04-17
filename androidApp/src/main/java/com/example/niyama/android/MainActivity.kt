package com.example.niyama.android

import ProfileRepository
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import di.Inject.instance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val profileRepository = instance<ProfileRepository>()
        CoroutineScope(context = Dispatchers.IO).launch {
            val profile = profileRepository.fetchProfileDetails()
            profileRepository.login()
            withContext(Dispatchers.Main) {
                val tv = findViewById<TextView>(R.id.textView)
                tv.text = "Title: ${profile.name}"
            }
        }
    }
}
