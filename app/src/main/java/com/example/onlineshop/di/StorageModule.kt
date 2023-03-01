package com.example.onlineshop.di

import com.example.onlineshop.core.data.storage.UserStorageImpl
import com.example.onlineshop.core.domain.UserStorage
import com.example.onlineshop.modules.auth.data.UserRepositoryImpl
import com.example.onlineshop.modules.auth.domain.UserRepository
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository = userRepositoryImpl

    @Provides
    fun provideUserStorage(userStorageImpl: UserStorageImpl): UserStorage = userStorageImpl
}