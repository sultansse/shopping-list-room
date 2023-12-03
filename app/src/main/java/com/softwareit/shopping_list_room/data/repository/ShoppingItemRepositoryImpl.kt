package com.softwareit.shopping_list_room.data.repository

import com.softwareit.shopping_list_room.data.source.DataSource
import com.softwareit.shopping_list_room.domain.model.ShoppingItem
import com.softwareit.shopping_list_room.domain.repository.ShoppingItemRepository
import javax.inject.Inject

class ShoppingItemRepositoryImpl @Inject constructor(
    private val local: DataSource.Local,
) : ShoppingItemRepository {

    override val shoppingList = local.getShoppingItemList()

    override suspend fun addShoppingItem(shoppingItem: ShoppingItem) =
        local.addShoppingItem(shoppingItem)

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) =
        local.deleteShoppingItem(shoppingItem)

    override suspend fun setIsPurchased(shoppingItem: ShoppingItem) =
        local.setIsPurchased(shoppingItem)
}