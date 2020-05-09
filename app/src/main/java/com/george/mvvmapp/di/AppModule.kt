package com.george.mvvmapp.di

import com.george.mvvmapp.util.REST_BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//i dont have any app level dependencies yet, the example has glide picture for his, https://www.youtube.com/watch?v=0rCOVY60lx0&list=PLgCYzUzKIBE8AOAspC3DHoBNZIBHbIOsC&index=11

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
