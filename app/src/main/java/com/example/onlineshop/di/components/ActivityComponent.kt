package com.example.onlineshop.di.components

import androidx.navigation.NavController
import com.example.onlineshop.di.scopes.ActivityScope
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun navController(controller: NavController): Builder

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): ActivityComponent
    }
}