package com.softwareit.shopping_list_room.data.mapper

import com.softwareit.shopping_list_room.data.model.ShoppingItemEntity
import com.softwareit.shopping_list_room.domain.model.ShoppingItem
import javax.inject.Inject

class ShoppingItemMapper @Inject constructor() {
    fun fromEntity(param: ShoppingItemEntity) = ShoppingItem(
        id = param.id,
        name = param.name,
        isPurchased = param.isPurchased
    )

    fun toEntity(param: ShoppingItem) = ShoppingItemEntity(
        id = param.id,
        name = param.name,
        isPurchased = param.isPurchased
    )

    fun fromEntity(params: List<ShoppingItemEntity>): List<ShoppingItem> =
        params.map(::fromEntity)

    fun toEntity(params: List<ShoppingItem>): List<ShoppingItemEntity> =
        params.map(::toEntity)
}