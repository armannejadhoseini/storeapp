package com.example.data.api

import com.example.data.entities.AddToCartResponseModel
import com.example.data.entities.ProductResponseModel
import com.example.data.entities.ProductsResponseModel
import retrofit2.Response
import com.example.data.utils.Constants.PRODUCTS_LIMIT
import com.example.domain.models.AddCartModel
import retrofit2.http.*

interface ApiService {

    @GET("products/")
    suspend fun getAllProducts(
        @Query("limit") limit: Int = PRODUCTS_LIMIT
    ): Response<List<ProductsResponseModel>>

    @GET("products/{id}/")
    suspend fun getProduct(
        @Path("id") id: Int
    ): Response<ProductResponseModel>

    @GET("products/categories/")
    suspend fun getAllCategories(): Response<List<String>>

    @POST("carts/")
    suspend fun addToCart(
        @Body item: AddCartModel
    ): Response<AddToCartResponseModel>

}