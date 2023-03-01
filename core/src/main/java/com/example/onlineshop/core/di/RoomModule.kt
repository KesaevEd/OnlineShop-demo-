package com.example.onlineshop.core.di

import android.content.Context
import androidx.room.Room
import com.example.onlineshop.core.data.storage.database.ShopDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoom(context: Context): ShopDataBase{
        return Room.databaseBuilder(
            context, ShopDataBase::class.java, "app_db"
        ).build()
    }
}