package com.example.data.mappers

import com.example.domain.models.CategoryModel
import javax.inject.Inject

class CategoryMapper @Inject constructor() {
    fun toCategory(response: List<String>): List<CategoryModel> {
        return response.map {
            CategoryModel(it)
        }
    }
}