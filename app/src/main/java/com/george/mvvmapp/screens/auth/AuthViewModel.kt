package com.george.mvvmapp.screens.auth

import androidx.lifecycle.ViewModel
import com.george.mvvmapp.network.auth.AuthApi
import timber.log.Timber
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    authApi: AuthApi
) : ViewModel() {

    init {
        Timber.i("auth activity view model created")
        Timber.i("checking auth api is initiated: $authApi")
    }
}