package com.example.data.di

import com.example.data.repositories.CartRepositoryImpl
import com.example.data.repositories.CategoryRepositoryImpl
import com.example.data.repositories.ProductRepositoryImpl
import com.example.domain.repositories.CartRepository
import com.example.domain.repositories.CategoryRepository
import com.example.domain.repositories.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class repoModule {

    @Binds
    abstract fun bindProfileRepo(
        homeRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository

    @Binds
    abstract fun bindCategoryRepo(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository

    @Binds
    abstract fun bindCartRepo(
        cartRepositoryImpl: CartRepositoryImpl
    ): CartRepository

}