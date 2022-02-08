package com.example.domain.usecaes

import com.example.domain.models.LoginModel
import com.example.domain.models.LoginResponseModel
import com.example.domain.repositories.ProfileRepository
import javax.inject.Inject

class LoginUsecaseImpl @Inject constructor(
    val repository: ProfileRepository
): LoginUsecase {
    override suspend fun login(loginModel: LoginModel): LoginResponseModel {
        return repository.login(loginModel)
    }
}