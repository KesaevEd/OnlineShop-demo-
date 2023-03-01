package com.example.onlineshop.core.domain

import android.net.Uri
import com.example.onlineshop.core.domain.entity.User

interface UserStorage {

    suspend fun saveUser(user: User)

    suspend fun checkUserExists(userName: String?): Boolean

    suspend fun getUserByUserName(userName: String?): User

    suspend fun updateImageUri(userName: String?, imageUri: Uri)

    suspend fun deleteUser()
}