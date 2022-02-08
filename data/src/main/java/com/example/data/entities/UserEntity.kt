package com.example.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(

    @PrimaryKey
    var id: String,
    var name: String,
    var email: String,
    var loginStatus: Boolean
)