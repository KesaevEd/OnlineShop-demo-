package com.example.onlineshop.modules.home.di

import com.example.onlineshop.di.components.AppComponent
import com.example.onlineshop.modules.home.presentation.HomeViewModel
import com.example.onlineshop.modules.profile.presentation.ProfileViewModel
import dagger.Component

@HomeScope
@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
interface HomeComponent {

    fun homeViewModel(): HomeViewModel.Factory
}