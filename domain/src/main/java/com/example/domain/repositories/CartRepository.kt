package com.example.domain.repositories

interface CartRepository {
    suspend fun addToCart(id: Int): Boolean
}