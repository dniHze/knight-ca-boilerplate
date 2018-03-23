package me.dnihze.kotlinnight.example.di

import dagger.Component
import me.dnihze.kotlinnight.example.ui.main.MainActivity

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}