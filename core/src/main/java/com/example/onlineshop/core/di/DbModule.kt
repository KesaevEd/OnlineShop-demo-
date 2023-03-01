package com.example.onlineshop.core.di

import com.example.onlineshop.core.data.storage.database.ShopDataBase
import com.example.onlineshop.core.data.storage.database.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun provideUserDao(shopDataBase: ShopDataBase): UserDao {
        return shopDataBase.userDao()
    }

}