package com.george.mvvmapp.di

import com.george.mvvmapp.screens.auth.AuthActivity
import com.george.mvvmapp.MainActivity
import com.george.mvvmapp.di.auth.AuthModule
import com.george.mvvmapp.di.auth.AuthViewModelModule
import com.george.mvvmapp.di.booking.BookingViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [AuthViewModelModule::class,
            AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector(
        modules = [BookingViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}
