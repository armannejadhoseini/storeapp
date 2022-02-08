package com.example.domain.usecaes

import com.example.domain.models.LoginModel
import com.example.domain.models.LoginResponseModel

interface LoginUsecase {
    suspend fun login(loginModel: LoginModel): LoginResponseModel
}