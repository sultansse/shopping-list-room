package com.softwareit.shopping_list_room.data.source

import com.softwareit.shopping_list_room.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface DataSource {
    interface Local {
        fun getShoppingItemList(): Flow<List<ShoppingItem>>
        suspend fun addShoppingItem(shoppingItem: ShoppingItem)
        suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)
        suspend fun setIsPurchased(shoppingItem: ShoppingItem)
    }
}