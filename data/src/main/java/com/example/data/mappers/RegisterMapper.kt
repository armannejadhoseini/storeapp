package com.example.data.mappers

import com.example.data.entities.RegisterEntity
import com.example.domain.models.RegisterModel
import javax.inject.Inject

class RegisterMapper @Inject constructor() {

    fun toMapper(registerModel: RegisterModel): RegisterEntity {
        return RegisterEntity(
            registerModel.name,
            registerModel.email,
            registerModel.password,
            registerModel.type
        )
    }
}