package com.example.ucp2pam

import android.app.Application
import com.example.ucp2pam.dependenciesinjection.ContainerApp

class GudangApp : Application() {
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}
