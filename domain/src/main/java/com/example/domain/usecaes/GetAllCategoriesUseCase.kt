package com.example.domain.usecaes

import com.example.domain.models.CategoryModel

interface GetAllCategoriesUseCase {
    suspend fun execute(): List<CategoryModel>
}