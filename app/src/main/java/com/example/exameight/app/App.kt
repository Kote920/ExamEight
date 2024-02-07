package com.example.exameight.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object{
        lateinit var application: Application
        private set
    }


    override fun onCreate() {
        super.onCreate()
        application = this
    }


}