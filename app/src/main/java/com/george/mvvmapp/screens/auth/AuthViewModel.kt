package com.george.mvvmapp.screens.auth

import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class AuthViewModel @Inject constructor() : ViewModel() {

    init {
        Timber.i("auth activity view model created")
    }
}