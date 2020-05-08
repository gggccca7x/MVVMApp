package com.george.mvvmapp.di

import com.george.mvvmapp.AuthActivity
import com.george.mvvmapp.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}