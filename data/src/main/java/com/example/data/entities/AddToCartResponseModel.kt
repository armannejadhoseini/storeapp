package com.example.data.entities

import com.example.domain.models.AddCartProductModel
import com.google.gson.annotations.SerializedName


data class AddToCartResponseModel(

    @SerializedName("id")
    var id: Int,

    @SerializedName("userId")
    var userId: Int,

    @SerializedName("date")
    var date: String,

    @SerializedName("products")
    var products: List<AddCartProductModel>,
)