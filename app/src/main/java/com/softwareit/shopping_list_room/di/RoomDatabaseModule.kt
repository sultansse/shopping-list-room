package com.softwareit.shopping_list_room.di

import android.content.Context
import androidx.room.Room
import com.softwareit.shopping_list_room.common.Const
import com.softwareit.shopping_list_room.data.source.local.db.AppDatabase
import com.softwareit.shopping_list_room.data.source.local.db.ShoppingItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomDatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = Const.ROOM_DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideShoppingItemDao(appDatabase: AppDatabase) : ShoppingItemDao {
        return appDatabase.shoppingItemDao()
    }
}