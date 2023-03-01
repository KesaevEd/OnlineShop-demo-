package com.example.onlineshop.core.data.storage.database.mappers

import android.net.Uri
import com.example.onlineshop.core.data.storage.database.entity.UserDbEntity
import com.example.onlineshop.core.domain.entity.User

fun User.toDbEntity(): UserDbEntity{
    return UserDbEntity(
        id = id,
        name = name,
        lastname = lastname,
        password = password,
        email = email,
        imageUri = imageUri.toString()
    )
}

fun UserDbEntity.toUser(): User{
    return User(
        name = name,
        lastname = lastname,
        password = password,
        email = email,
        imageUri = imageUri?.let { Uri.parse(imageUri) }
    )
}