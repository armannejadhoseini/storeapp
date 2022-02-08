package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

    @SerializedName("name")
    var name: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("password")
    var password: String,

    @SerializedName("_id")
    var id: String
)
