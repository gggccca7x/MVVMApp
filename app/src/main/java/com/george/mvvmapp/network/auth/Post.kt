package com.george.mvvmapp.network.auth

import com.google.gson.annotations.SerializedName

data class Post(
    var userId: Int,

    var id: Int,

    var title: String,

    @SerializedName("body")
    var text: String
)