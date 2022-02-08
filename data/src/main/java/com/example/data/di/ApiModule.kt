package com.example.data.di

import android.content.Context
import com.example.data.api.ApiService
import com.example.data.utils.Constants.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS)
        return okHttpBuilder.build()
    }

    @Provides
    fun providesRetrofit(okhhtpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhhtpClient)
            .build()
    }

    @Provides
    @Singleton
    fun bindApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}