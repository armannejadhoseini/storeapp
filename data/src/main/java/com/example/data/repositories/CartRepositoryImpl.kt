package com.example.data.repositories

import android.util.Log
import com.example.data.api.ApiService
import com.example.domain.models.AddCartModel
import com.example.domain.models.AddCartProductModel
import com.example.domain.repositories.CartRepository
import java.lang.Exception
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val api: ApiService
) : CartRepository {

    override suspend fun addToCart(id: Int): Boolean {

        val bodyItem = AddCartModel(products = listOf(AddCartProductModel(id, 1)))

        val request = api.addToCart(bodyItem)

        if (request.isSuccessful) {
            return true
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