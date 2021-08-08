package com.example.myapplication.application

import android.app.Application
import com.example.myapplication.di.application
import com.example.myapplication.di.mainScreen
import org.koin.core.context.startKoin

class DictionaryApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                application+mainScreen
            )
        }
    }
}