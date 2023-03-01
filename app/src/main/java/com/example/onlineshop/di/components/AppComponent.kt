package com.example.onlineshop.di.components

import com.example.onlineshop.core.data.storage.database.ShopDataBase
import com.example.onlineshop.core.di.AppModule
import com.example.onlineshop.core.di.DbModule
import com.example.onlineshop.core.di.RoomModule
import com.example.onlineshop.core.domain.UserStorage
import com.example.onlineshop.di.NetworkModule
import com.example.onlineshop.di.StorageModule
import com.example.onlineshop.modules.auth.domain.UserRepository
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        StorageModule::class,
        DbModule::class,
        RoomModule::class
    ]
)

interface AppComponent {

    fun room(): ShopDataBase

    fun retrofit(): Retrofit

    fun userRepository(): UserRepository

    fun userStorage(): UserStorage
}