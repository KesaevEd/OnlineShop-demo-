package com.example.onlineshop.core.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.onlineshop.core.data.storage.database.dao.UserDao
import com.example.onlineshop.core.data.storage.database.entity.UserDbEntity

@Database(entities = [UserDbEntity::class], version = 1)
abstract class ShopDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}