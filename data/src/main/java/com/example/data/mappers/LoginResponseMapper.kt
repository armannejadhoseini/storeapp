package com.example.data.mappers

import com.example.data.entities.LoginResponse
import com.example.domain.models.LoginResponseModel
import javax.inject.Inject

class LoginResponseMapper @Inject constructor() {

    fun toMapper(loginResponse: LoginResponse): LoginResponseModel {
        return LoginResponseModel(
            loginResponse.Status,
        )
    }
}