package com.example.domain.usecaes

import androidx.lifecycle.LiveData
import com.example.domain.repositories.ProfileRepository
import javax.inject.Inject

class LoginStatusUsecaseImpl @Inject constructor(
    val repository: ProfileRepository
): LoginStatusUsecase {
    override suspend fun getSatus(): LiveData<Boolean> {
        return repository.getSatus()
    }
}