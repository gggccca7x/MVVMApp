package com.george.mvvmapp.di.auth

import androidx.lifecycle.ViewModel
import com.george.mvvmapp.di.ViewModelKey
import com.george.mvvmapp.screens.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindBookingViewModel(viewModel: AuthViewModel) : ViewModel
}