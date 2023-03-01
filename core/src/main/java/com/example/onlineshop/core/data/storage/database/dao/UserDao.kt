package com.example.onlineshop.core.data.storage.database.dao

import android.telephony.mbms.StreamingServiceInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.onlineshop.core.data.storage.database.entity.UserDbEntity


@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: UserDbEntity)

    @Query("SELECT EXISTS(SELECT 1 FROM user WHERE name = :userName)")
    suspend fun checkUserExists(userName: String?): Boolean

    @Query("SELECT * FROM user WHERE name = :userName")
    suspend fun getUserByUserName(userName: String?): UserDbEntity

    @Query("UPDATE user SET image_uri = :imageUri WHERE name = :userName")
    suspend fun updateImageUri(userName: String?, imageUri: String?)

    @Query("DELETE FROM user")
    suspend fun deleteUser()

}