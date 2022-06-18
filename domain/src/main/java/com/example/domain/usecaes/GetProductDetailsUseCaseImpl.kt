package com.example.domain.usecaes

import com.example.domain.models.ProductModel
import com.example.domain.repositories.ProductRepository
import javax.inject.Inject

class GetProductDetailsUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
): GetProductDetailsUseCase {
    override suspend fun execute(id: Int): ProductModel {
        return productRepository.getProductDetails(id)
    }
}