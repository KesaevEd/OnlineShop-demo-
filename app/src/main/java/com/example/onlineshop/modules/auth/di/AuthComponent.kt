package com.example.onlineshop.modules.auth.di

import com.example.onlineshop.di.components.AppComponent
import com.example.onlineshop.modules.auth.login.presentation.LoginViewModel
import com.example.onlineshop.modules.auth.signin.presentation.SignInViewModel
import com.example.onlineshop.modules.profile.presentation.ProfileViewModel
import dagger.Component

@AuthScope
@Component(dependencies = [AppComponent::class], modules = [AuthModule::class])
interface AuthComponent {

    fun signInViewModel(): SignInViewModel.Factory

    fun loginViewModel(): LoginViewModel.Factory

    fun profileViewModel(): ProfileViewModel.Factory
}