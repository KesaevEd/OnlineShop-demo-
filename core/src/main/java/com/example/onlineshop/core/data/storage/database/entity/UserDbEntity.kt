package com.example.onlineshop.core.data.storage.database.entity

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "lastname") val lastname: String? = null,
    @ColumnInfo(name = "password") val password: String? = null,
    @ColumnInfo(name = "email") val email: String? = null,
    @ColumnInfo(name = "image_uri") val imageUri: String? = null,
)