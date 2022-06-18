package com.example.domain.repositories

import com.example.domain.models.ProductModel
import com.example.domain.models.ProductsModel

interface ProductRepository {
    suspend fun getAllProducts(): List<ProductsModel>
    suspend fun getProductDetails(id: Int): ProductModel
}