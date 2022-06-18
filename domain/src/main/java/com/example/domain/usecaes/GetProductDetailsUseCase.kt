package com.example.domain.usecaes

import com.example.domain.models.ProductModel

interface GetProductDetailsUseCase {
    suspend fun execute(id: Int): ProductModel
}