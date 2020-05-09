package com.george.mvvmapp.network.auth

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface AuthApi {

    @GET
    fun getInformation(): Call<ResponseBody>

    //pass in the relative url - after the base url
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}