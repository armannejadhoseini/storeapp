package com.example.data.mappers

import com.example.data.entities.ProductResponseModel
import com.example.domain.models.ProductModel
import javax.inject.Inject

class ProductMapper @Inject constructor(){
    fun toMapper(response: ProductResponseModel): ProductModel {
        return ProductModel(
            response.id,
            response.title,
            response.price,
            response.description,
            response.category,
            response.image
        )
    }
}