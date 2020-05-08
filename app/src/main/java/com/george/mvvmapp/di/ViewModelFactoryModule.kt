package com.george.mvvmapp.di

import androidx.lifecycle.ViewModelProvider
import com.george.mvvmapp.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(providerFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}