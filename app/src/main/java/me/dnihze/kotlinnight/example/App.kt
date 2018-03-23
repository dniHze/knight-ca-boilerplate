package me.dnihze.kotlinnight.example

import android.app.Activity
import android.app.Application
import me.dnihze.kotlinnight.example.di.ApplicationComponent
import me.dnihze.kotlinnight.example.di.ApplicationModule
import me.dnihze.kotlinnight.example.di.DaggerApplicationComponent

class App : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    val component: ApplicationComponent
        get() = applicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(applicationContext))
                .build()
    }

    companion object {
        operator fun get(activity: Activity): App {
            return activity.application as? App ?: throw IllegalStateException()
        }
    }
}