package com.softwareit.shopping_list_room.domain.repository

import com.softwareit.shopping_list_room.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface ShoppingItemRepository {
    val shoppingList: Flow<List<ShoppingItem>>
    suspend fun addShoppingItem(shoppingItem: ShoppingItem)
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)
    suspend fun setIsPurchased(shoppingItem: ShoppingItem)
}