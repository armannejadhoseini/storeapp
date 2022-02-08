package com.example.domain.models

data class RegisterResponseModel(
    var name: String,
    var email: String,
    var password: String,
    var id: Int
)
