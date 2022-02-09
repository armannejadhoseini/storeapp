package com.example.domain.usecaes

import com.example.domain.models.RegisterModel
import com.example.domain.models.RegisterResponseModel
import com.example.domain.repositories.ProfileRepository
import javax.inject.Inject

class RegisterUsecaseImpl @Inject constructor(
    val repository: ProfileRepository
) : RegisterUsecase {
    override suspend fun register(registerModel: RegisterModel): RegisterResponseModel {
        //return repository.register(registerModel)
        TODO("Not yet implemented")
    }
}