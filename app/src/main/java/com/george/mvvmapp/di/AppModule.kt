package com.george.mvvmapp.di

import android.app.Application
import com.george.mvvmapp.util.REST_BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// could/should this be abstract?
@Module
class AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(REST_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}
