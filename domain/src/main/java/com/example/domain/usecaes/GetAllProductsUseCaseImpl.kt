package com.example.domain.usecaes

import com.example.domain.models.ProductsModel
import com.example.domain.repositories.ProductRepository
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetAllProducsUseCase {

    override suspend fun execute(): List<ProductsModel> {
        return productRepository.getAllProducts()
    }
}