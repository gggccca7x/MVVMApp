package com.george.mvvmapp.di

import com.george.mvvmapp.MainActivity
import com.george.mvvmapp.di.booking.BookingViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [BookingViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}