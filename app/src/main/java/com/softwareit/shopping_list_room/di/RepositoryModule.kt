package com.softwareit.shopping_list_room.di

import com.softwareit.shopping_list_room.data.repository.ShoppingItemRepositoryImpl
import com.softwareit.shopping_list_room.domain.repository.ShoppingItemRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindShoppingItemRepository(shoppingItemRepositoryImpl: ShoppingItemRepositoryImpl): ShoppingItemRepository
}