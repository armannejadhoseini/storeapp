package com.example.data.mappers

import com.example.data.entities.RegisterResponse
import com.example.domain.models.RegisterResponseModel
import javax.inject.Inject

class RegisterResponseMapper @Inject constructor() {

    fun toMapper(registerResponse: RegisterResponse): RegisterResponseModel {
        return RegisterResponseModel(
            registerResponse.name,
            registerResponse.email,
            registerResponse.password,
            registerResponse.id
        )
    }
}