package com.example.domain.usecaes

import com.example.domain.models.CategoryModel
import com.example.domain.repositories.CategoryRepository
import javax.inject.Inject

class GetAllCategoriesUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
): GetAllCategoriesUseCase {

    override suspend fun execute(): List<CategoryModel> {
        return categoryRepository.getAllCategories()
    }

}