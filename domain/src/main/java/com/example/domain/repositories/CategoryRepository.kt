package com.example.domain.repositories

import com.example.domain.models.CategoryModel

interface CategoryRepository {
    suspend fun getAllCategories(): List<CategoryModel>
}