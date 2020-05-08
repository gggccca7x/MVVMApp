package com.george.mvvmapp

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var someString: String

    var isAppNull: Boolean? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        Timber.i("string is: $someString")
        Timber.i("is app null: $isAppNull")

    }
}
