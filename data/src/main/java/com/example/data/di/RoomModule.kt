package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.dao.UserDao
import com.example.data.db.StoreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RoomModule() {

    @Provides
    fun ProvideDatabase(@ApplicationContext context: Context): StoreDatabase {
        return Room.databaseBuilder(
            context,
            StoreDatabase::class.java,
            "store-db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvideUserDao(db: StoreDatabase): UserDao {
        return  db.UserDao()
    }
}