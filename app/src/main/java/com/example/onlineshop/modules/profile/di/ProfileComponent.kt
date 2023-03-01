package com.example.onlineshop.modules.profile.di

import com.example.onlineshop.di.components.AppComponent
import com.example.onlineshop.modules.auth.di.AuthScope
import com.example.onlineshop.modules.profile.presentation.ProfileViewModel
import dagger.Component

@ProfileScope
@Component(dependencies = [AppComponent::class], modules = [ProfileModule::class])
interface ProfileComponent {

    fun profileViewModel(): ProfileViewModel.Factory
}