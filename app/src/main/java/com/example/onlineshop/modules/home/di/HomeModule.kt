package com.example.onlineshop.modules.home.di

import com.example.onlineshop.data.ProductRepositoryImpl
import com.example.onlineshop.data.UserRepositoryImpl
import com.example.onlineshop.domain.ProductRepository
import com.example.onlineshop.domain.UserRepository
import com.example.onlineshop.modules.auth.di.AuthScope
import com.example.onlineshop.modules.profile.di.ProfileScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class HomeModule {

    @HomeScope
    @Provides
    fun provideProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository =
        productRepositoryImpl

    @HomeScope
    @Provides
    @Named("home_repository")
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository =
        userRepositoryImpl
}