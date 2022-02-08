package com.example.domain.repositories

import com.example.domain.models.LoginModel
import com.example.domain.models.LoginResponseModel

interface ProfileRepository {
    suspend fun login(loginModel: LoginModel): LoginResponseModel
}