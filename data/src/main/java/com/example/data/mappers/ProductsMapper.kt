package com.example.data.mappers

import com.example.data.entities.ProductsResponseModel
import com.example.domain.models.ProductsModel
import javax.inject.Inject

class ProductsMapper @Inject constructor() {
    fun toMapper(response: List<ProductsResponseModel>): List<ProductsModel> {
        return response.map {
            ProductsModel(it.id, it.title, it.price, it.description, it.category, it.image)
        }
    }
}