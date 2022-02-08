package com.example.data.mappers

import com.example.data.entities.LoginEntity
import com.example.domain.models.LoginModel
import javax.inject.Inject

class LoginMapper @Inject constructor() {

    fun toMapper(loginModel: LoginModel): LoginEntity {
        return LoginEntity(
            loginModel.email,
            loginModel.password
        )
    }

}