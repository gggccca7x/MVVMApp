package com.george.mvvmapp.di

import com.george.mvvmapp.AuthActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity

    companion object {
        @Provides
        fun someString() : String {
            return "this is a test string"
        }
    }
}