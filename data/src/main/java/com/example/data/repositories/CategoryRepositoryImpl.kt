package com.example.data.repositories

import com.example.data.api.ApiService
import com.example.data.mappers.CategoryMapper
import com.example.domain.models.CategoryModel
import com.example.domain.repositories.CategoryRepository
import java.lang.Exception
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val mapper: CategoryMapper
) : CategoryRepository {
    override suspend fun getAllCategories(): List<CategoryModel> {

        val request = api.getAllCategories()

        if (request.isSuccessful) {
            return mapper.toCategory(request.body()!!)

        } else {
            when (request.code()) {

                300 -> {
                    throw Exception("Redirected")
                }
                400 -> {
                    throw Exception("Bad Request")
                }
                500 -> {
                    throw Exception("Internal Server Error")
                }
                else -> {
                    throw Exception("Unknown Error")
                }
            }
        }
    }
}