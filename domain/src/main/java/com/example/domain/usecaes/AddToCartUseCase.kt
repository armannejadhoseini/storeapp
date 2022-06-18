package com.example.domain.usecaes

interface AddToCartUseCase {
    suspend fun execute(id: Int): Boolean
}