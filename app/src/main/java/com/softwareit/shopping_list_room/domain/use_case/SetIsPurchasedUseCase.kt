package com.softwareit.shopping_list_room.domain.use_case

import com.softwareit.shopping_list_room.domain.model.ShoppingItem
import com.softwareit.shopping_list_room.domain.repository.ShoppingItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SetIsPurchasedUseCase @Inject constructor(
    private val shoppingItemRepository: ShoppingItemRepository
) {
    suspend operator fun invoke(shoppingItem: ShoppingItem) = withContext(Dispatchers.IO) {
        shoppingItemRepository.setIsPurchased(shoppingItem)
    }
}