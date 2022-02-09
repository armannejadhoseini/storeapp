package com.example.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT loginStatus FROM user")
    fun getUserStatus(): LiveData<Boolean>
}