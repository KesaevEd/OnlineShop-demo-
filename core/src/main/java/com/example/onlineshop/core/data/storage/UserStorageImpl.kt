package com.example.onlineshop.core.data.storage

import android.net.Uri
import com.example.onlineshop.core.data.storage.database.dao.UserDao
import com.example.onlineshop.core.data.storage.database.mappers.toDbEntity
import com.example.onlineshop.core.data.storage.database.mappers.toUser
import com.example.onlineshop.core.domain.UserStorage
import com.example.onlineshop.core.domain.entity.User
import javax.inject.Inject

class UserStorageImpl @Inject constructor(
    private val userDao: UserDao
): UserStorage {
    override suspend fun saveUser(user: User) {
        userDao.insert(user.toDbEntity())
    }

    override suspend fun checkUserExists(userName: String?): Boolean {
        return userDao.checkUserExists(userName)
    }

    override suspend fun getUserByUserName(userName: String?): User {
        return userDao.getUserByUserName(userName).toUser()
    }

    override suspend fun updateImageUri(userName: String?, imageUri: Uri) {
        userDao.updateImageUri(userName, imageUri.toString())
    }

    override suspend fun deleteUser() {
        userDao.deleteUser()
    }
}