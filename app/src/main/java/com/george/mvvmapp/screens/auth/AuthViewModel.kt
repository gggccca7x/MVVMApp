package com.george.mvvmapp.screens.auth

import androidx.lifecycle.ViewModel
import com.george.mvvmapp.network.auth.AuthApi
import com.george.mvvmapp.network.auth.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    authApi: AuthApi
) : ViewModel() {

    init {
        Timber.i("auth activity view model created")
        Timber.i("checking auth api is initiated: $authApi")

        val call = authApi.getPosts()
        call.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(!response.isSuccessful) {
                    Timber.i("failure to get data, maybe no internet connection")
                    return
                } else {
                    response.body()?.forEach {
                        Timber.i("post: $it")
                    }
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Timber.i("failure to get data, maybe no internet connection")
            }
        })
    }
}