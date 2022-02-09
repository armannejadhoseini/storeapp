package com.example.domain.usecaes

import com.example.domain.models.RegisterModel
import com.example.domain.models.RegisterResponseModel

interface RegisterUsecase {
    suspend fun register(registerModel: RegisterModel): RegisterResponseModel
}