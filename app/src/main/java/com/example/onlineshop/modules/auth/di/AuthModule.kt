package com.example.onlineshop.modules.auth.di

import com.example.onlineshop.modules.auth.data.UserRepositoryImpl
import com.example.onlineshop.modules.auth.domain.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AuthModule {

    @AuthScope
    @Provides
    @Named("sign_in_repository")
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository = userRepositoryImpl
}