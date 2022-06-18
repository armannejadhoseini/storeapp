package com.example.domain.usecaes

import com.example.domain.models.ProductsModel

interface GetAllProducsUseCase {
    suspend fun execute(): List<ProductsModel>
}