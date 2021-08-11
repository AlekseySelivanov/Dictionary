package com.example.myapplication.application

import android.app.Application
import com.example.myapplication.di.application
import com.example.myapplication.di.historyScreen
import com.example.myapplication.di.historySearchScreen
import com.example.myapplication.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DictionaryApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                application + mainScreen + historyScreen + historySearchScreen
            )
        }
    }
}