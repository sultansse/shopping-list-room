package com.softwareit.shopping_list_room.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.softwareit.shopping_list_room.data.model.ShoppingItemEntity
import javax.inject.Singleton

@Singleton
@Database(entities = [ShoppingItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shoppingItemDao(): ShoppingItemDao
}