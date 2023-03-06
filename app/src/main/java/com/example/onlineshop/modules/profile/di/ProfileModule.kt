package com.example.onlineshop.modules.profile.di

import com.example.onlineshop.data.UserRepositoryImpl
import com.example.onlineshop.domain.UserRepository
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