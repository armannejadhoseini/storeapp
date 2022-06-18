package com.example.domain.models

data class AddCartModel(

    var userId: Int = 1,
    var date: String = "2020-02-03",
    var products: List<AddCartProductModel>
)