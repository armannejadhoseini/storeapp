package com.example.domain.usecaes

import com.example.domain.repositories.CartRepository
import javax.inject.Inject

class AddToCartUseCaseImpl @Inject constructor(
    private val cartRepository: CartRepository
): AddToCartUseCase {
    override suspend fun execute(id: Int): Boolean {
        return cartRepository.addToCart(id)
    }
}