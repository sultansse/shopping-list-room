package com.softwareit.shopping_list_room.data.source.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.softwareit.shopping_list_room.data.model.ShoppingItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingItemDao {

    @Query("SELECT * FROM shopping_items")
    fun getShoppingItemList(): Flow<List<ShoppingItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(shoppingItemEntity: ShoppingItemEntity)

    @Delete
    suspend fun delete(shoppingItemEntity: ShoppingItemEntity)

    @Query("UPDATE shopping_items SET isPurchased = :isPurchased WHERE id = :id")
    suspend fun setIsPurchased(id: Int, isPurchased: Boolean)
}