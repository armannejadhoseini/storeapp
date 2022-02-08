package com.example.data.di

import com.example.data.repositories.ProfileRepositoryimpl
import com.example.domain.repositories.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class repoModule {

    @Binds
    abstract fun bindProfileRepo(
        profileRepositoryImpl: ProfileRepositoryimpl
    ): ProfileRepository

}