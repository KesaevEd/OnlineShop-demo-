package com.example.onlineshop.modules.profile.di

import com.example.onlineshop.modules.auth.data.UserRepositoryImpl
import com.example.onlineshop.modules.auth.domain.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ProfileModule {

    @ProfileScope
    @Provides
    @Named("profile_repository")
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository = userRepositoryImpl
}