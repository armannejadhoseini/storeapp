package com.example.data.repositories

import android.util.Log
import com.example.data.api.ApiService
import com.example.data.mappers.ProductMapper
import com.example.data.mappers.ProductsMapper
import com.example.domain.models.ProductModel
import com.example.domain.models.ProductsModel
import com.example.domain.repositories.ProductRepository
import java.lang.Exception
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val productMapper: ProductMapper,
    private val productsMapper: ProductsMapper
) : ProductRepository {
    override suspend fun getAllProducts(): List<ProductsModel> {

        val request = api.getAllProducts()

        if (request.isSuccessful) {
            return productsMapper.toMapper(request.body()!!)

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

    override suspend fun getProductDetails(id: Int): ProductModel {

        val request = api.getProduct(id)

        if (request.isSuccessful) {
            return productMapper.toMapper(request.body()!!)

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