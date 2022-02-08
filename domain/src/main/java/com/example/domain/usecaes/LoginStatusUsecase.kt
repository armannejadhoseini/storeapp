package com.example.domain.usecaes

interface LoginStatusUsecase {
    suspend fun getSatus(): Boolean
}