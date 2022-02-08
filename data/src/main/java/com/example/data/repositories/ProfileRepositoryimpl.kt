package com.example.data.repositories

import android.util.Log
import com.example.data.api.ApiService
import com.example.data.mappers.LoginMapper
import com.example.data.mappers.LoginResponseMapper
import com.example.data.mappers.RegisterMapper
import com.example.data.mappers.RegisterResponseMapper
import com.example.domain.models.LoginModel
import com.example.domain.models.LoginResponseModel
import com.example.domain.models.RegisterModel
import com.example.domain.models.RegisterResponseModel
import com.example.domain.repositories.ProfileRepository
import java.io.IOException
import javax.inject.Inject

class ProfileRepositoryimpl @Inject constructor(
    val loginMapper: LoginMapper,
    val loginResponseMapper: LoginResponseMapper,
    val registerMapper: RegisterMapper,
    val registerResponseMapper: RegisterResponseMapper,
    val apiService: ApiService
) : ProfileRepository {
    override suspend fun login(loginModel: LoginModel): LoginResponseModel {
        //map the data
        val loginEntity = loginMapper.toMapper(loginModel)

        //make the request
        val request = apiService.login(loginEntity)

        //check the request
        if (request.isSuccessful) {
            return loginResponseMapper.toMapper(request.body()!!)
        } else {
            Log.d("request error", request.errorBody()!!.string())
            when (request.code()) {
                500 -> {
                    throw IOException("Internal Server Error")
                }
                400 -> {
                    throw IOException("Bad Request. Your input isn't correct")
                }
                else -> {
                    throw IOException("Your input isn't correct ")
                }
            }
        }
    }

    override suspend fun register(registerModel: RegisterModel): RegisterResponseModel {
        //map the register data
        val registerEntity = registerMapper.toMapper(registerModel)

        //make a request
        val request = apiService.register(registerEntity)

        //check request
        if (request.isSuccessful) {
            return registerResponseMapper.toMapper(request.body()!!)
        } else {
            Log.d("request error", request.errorBody()!!.string())
            when (request.code()) {
                500 -> {
                    throw IOException("Internal Server Error")
                }
                400 -> {
                    throw IOException("Bad Request. Your input isn't correct")
                }
                else -> {
                    throw IOException("Your input isn't correct ")
                }
            }
        }
    }
}