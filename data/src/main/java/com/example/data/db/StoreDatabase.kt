package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.UserDao
import com.example.data.entities.UserEntity


@Database(
    entities = [
        UserEntity::class
    ],
    version = 1
)
abstract class StoreDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
}