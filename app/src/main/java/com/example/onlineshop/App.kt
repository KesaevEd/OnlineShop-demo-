package com.example.onlineshop

import android.app.Application
import com.example.onlineshop.core.di.AppModule
import com.example.onlineshop.core.di.DbModule
import com.example.onlineshop.di.NetworkModule
import com.example.onlineshop.di.components.AppComponent
import com.example.onlineshop.di.components.DaggerAppComponent
import com.example.onlineshop.di.StorageModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .storageModule(StorageModule())
            .networkModule(NetworkModule())
            .dbModule(DbModule())
            .build()
    }

    companion object {
        lateinit var component: AppComponent
            private set
    }

}