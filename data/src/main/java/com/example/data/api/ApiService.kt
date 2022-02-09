package com.example.data.api

import com.example.data.entities.LoginEntity
import com.example.data.entities.LoginResponse
import com.example.data.entities.RegisterEntity
import com.example.data.entities.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("usrers/signin/")
    suspend fun login(
        @Body loginEntity: LoginEntity
    ): Response<LoginResponse>


    @POST("users/signup/")
    @FormUrlEncoded
    suspend fun register(
        @Body registerEntity: RegisterEntity
    ): Response<RegisterResponse>


}