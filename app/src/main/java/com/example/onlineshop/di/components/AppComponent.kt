package com.example.onlineshop.di.components

import com.example.onlineshop.core.data.network.ShopApi
import com.example.onlineshop.core.data.storage.database.ShopDataBase
import com.example.onlineshop.core.data.storage.database.UserSharedPref
import com.example.onlineshop.core.data.storage.database.entity.di.AppModule
import com.example.onlineshop.core.data.storage.database.entity.di.DbModule
import com.example.onlineshop.core.data.storage.database.entity.di.RoomModule
import com.example.onlineshop.core.domain.UserStorage
import com.example.onlineshop.di.NetworkModule
import com.example.onlineshop.di.StorageModule
import com.example.onlineshop.domain.UserRepository
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

    fun userPref(): UserSharedPref

    fun shopApi(): ShopApi

    fun userRepository(): UserRepository

    fun userStorage(): UserStorage
}