package com.example.android.dagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.dagger.ViewModelFactory
import com.example.android.dagger.login.LoginViewModel
import com.example.android.dagger.user.UserManager
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}

@Module
class ViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun provideLoginViewModel(
        userManager: UserManager
    ): ViewModel {
        return LoginViewModel(userManager)
    }
}

@MapKey
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class ViewModelKey(val value: KClass<out ViewModel>)