package com.example.domain.usecaes

import com.example.domain.repositories.ProfileRepository
import javax.inject.Inject

class LoginStatusUsecaseImpl @Inject constructor(
    val repository: ProfileRepository
): LoginStatusUsecase {
    override suspend fun getSatus(): Boolean {
        return repository.getSatus()
    }
}