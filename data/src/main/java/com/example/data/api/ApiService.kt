package com.example.data.api

import com.example.data.entities.LoginEntity
import com.example.data.entities.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("usrers/signin/")
    @FormUrlEncoded
    suspend fun login(
        @Body loginEntity: LoginEntity
    ): Response<LoginResponse>




}