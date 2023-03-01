package com.example.onlineshop.modules.auth.domain

import android.net.Uri
import com.example.onlineshop.core.data.storage.database.entity.UserDbEntity
import com.example.onlineshop.core.domain.entity.User

interface UserRepository {

    suspend fun saveUserToDb(user: User)

    suspend fun checkUserExist(userName: String?): Boolean

    suspend fun getUserByName(userName: String?): User

    suspend fun updateImageUri(userName: String?, imageUri: Uri)

    suspend fun deleteUser()
}