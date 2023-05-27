package iti.workshop.newApp.di

import android.app.Application

class APP: Application() {
    lateinit var  appDependency: Unit

    override fun onCreate() {
        super.onCreate()
        appDependency = AppDependency.initialization(applicationContext)
    }

}