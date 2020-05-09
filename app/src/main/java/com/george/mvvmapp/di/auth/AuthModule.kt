package com.george.mvvmapp.di.auth

import com.george.mvvmapp.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

//where to add the dependencies for the auth sub component - the auth activity and view model
@Module
class AuthModule {

    companion object {

        @Provides
        fun provideAuthApi(retrofit: Retrofit) : AuthApi {
            return retrofit.create(AuthApi::class.java)
        }
    }

}