package com.george.mvvmapp.di

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    companion object {
        @Provides
        fun someString() : String {
            return "this is a test string"
        }

        @Provides
        fun getApp(application: Application?) : Boolean {
            return application == null
        }
    }
}
