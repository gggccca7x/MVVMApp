package com.george.mvvmapp.screens.auth

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.george.mvvmapp.R
import com.george.mvvmapp.databinding.ActivityAuthBinding
import com.george.mvvmapp.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel: AuthViewModel

    var providerFactory: ViewModelProviderFactory? = null
        @Inject get

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityAuthBinding = DataBindingUtil.setContentView(this, R.layout.activity_auth)

        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel::class.java)

    }
}
