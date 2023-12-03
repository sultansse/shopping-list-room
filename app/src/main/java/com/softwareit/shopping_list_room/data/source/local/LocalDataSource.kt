package com.softwareit.shopping_list_room.data.source.local

import com.softwareit.shopping_list_room.data.mapper.ShoppingItemMapper
import com.softwareit.shopping_list_room.data.source.DataSource
import com.softwareit.shopping_list_room.data.source.local.db.ShoppingItemDao
import com.softwareit.shopping_list_room.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val shoppingItemDao: ShoppingItemDao,
    private val shoppingItemMapper: ShoppingItemMapper
) : DataSource.Local {
    override fun getShoppingItemList(): Flow<List<ShoppingItem>> =
        shoppingItemDao.getShoppingItemList().map(shoppingItemMapper::fromEntity)

    override suspend fun addShoppingItem(shoppingItem: ShoppingItem) =
        shoppingItemDao.insert(
            shoppingItem.run(shoppingItemMapper::toEntity)
        )

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItemDao.delete(
            shoppingItem.run(shoppingItemMapper::toEntity)
        )
    }

    override suspend fun setIsPurchased(shoppingItem: ShoppingItem) {
        shoppingItemDao.setIsPurchased(
            id = shoppingItem.id,
            isPurchased = shoppingItem.isPurchased
        )
    }
}