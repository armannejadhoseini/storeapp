package com.example.domain.usecaes

import androidx.lifecycle.LiveData

interface LoginStatusUsecase {
    suspend fun getSatus(): LiveData<Boolean>
}