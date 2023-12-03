package com.softwareit.shopping_list_room.domain.use_case

import com.softwareit.shopping_list_room.domain.model.ShoppingItem
import com.softwareit.shopping_list_room.domain.repository.ShoppingItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetShoppingItemListUseCase @Inject constructor(
    private val shoppingItemRepository: ShoppingItemRepository
) {
    operator fun invoke(): Flow<List<ShoppingItem>> = shoppingItemRepository.shoppingList
}