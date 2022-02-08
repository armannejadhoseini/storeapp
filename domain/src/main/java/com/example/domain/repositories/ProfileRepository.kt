package com.example.domain.repositories

import com.example.domain.models.LoginModel
import com.example.domain.models.LoginResponseModel
import com.example.domain.models.RegisterModel
import com.example.domain.models.RegisterResponseModel

interface ProfileRepository {
    suspend fun login(loginModel: LoginModel): LoginResponseModel
    suspend fun register(registerModel: RegisterModel): RegisterResponseModel
}