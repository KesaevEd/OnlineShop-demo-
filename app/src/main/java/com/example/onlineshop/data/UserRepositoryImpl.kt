package com.example.onlineshop.data

import android.net.Uri
import com.example.onlineshop.core.domain.UserStorage
import com.example.onlineshop.core.domain.entity.User
import com.example.onlineshop.domain.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userStorage: UserStorage
): UserRepository {
    override suspend fun saveUserToDb(user: User) {
        userStorage.saveUser(user)
    }

    override suspend fun checkUserExist(userName: String?): Boolean {
        return userStorage.checkUserExists(userName)
    }

    override suspend fun getUserByName(userName: String?): User {
        return userStorage.getUserByUserName(userName)
    }

    override suspend fun updateImageUri(userName: String?, imageUri: Uri) {
        return userStorage.updateImageUri(userName,imageUri)
    }

    override suspend fun deleteUser() {
        userStorage.deleteUser()
    }
}