package com.softwareit.shopping_list_room.domain.model

data class ShoppingItem(
    val id: Int,
    val name: String,
    var isPurchased: Boolean,
) {
    constructor(name: String) : this(id = 0, name = name, isPurchased = false)
}