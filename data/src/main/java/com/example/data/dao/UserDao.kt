package com.example.data.dao

import androidx.room.Query

interface UserDao {

    @Query("SELECT loginStatus FROM user")
    fun getUserStatus(): Boolean
}