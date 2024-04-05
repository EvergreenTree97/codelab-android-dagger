package com.example.android.dagger.di

import com.example.android.dagger.login.LoginActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ViewModelModule::class, ViewModelFactoryModule::class])
interface LoginComponent {

    // Factory to create instances of LoginComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: LoginActivity)
}