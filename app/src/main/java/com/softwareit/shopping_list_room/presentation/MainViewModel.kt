package com.softwareit.shopping_list_room.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.softwareit.shopping_list_room.domain.model.ShoppingItem
import com.softwareit.shopping_list_room.domain.use_case.AddShoppingItemUseCase
import com.softwareit.shopping_list_room.domain.use_case.DeleteShoppingItemUseCase
import com.softwareit.shopping_list_room.domain.use_case.GetShoppingItemListUseCase
import com.softwareit.shopping_list_room.domain.use_case.SetIsPurchasedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getShoppingItemListUseCase: GetShoppingItemListUseCase,
    private val addShoppingItemUseCase: AddShoppingItemUseCase,
    private val deleteShoppingItemUseCase: DeleteShoppingItemUseCase,
    private val setIsPurchasedUseCase: SetIsPurchasedUseCase,
) : ViewModel() {

    val shoppingList: LiveData<List<ShoppingItem>> = getShoppingItemListUseCase().asLiveData()

    fun addShoppingItem(name: String) = viewModelScope.launch {
        addShoppingItemUseCase(
            ShoppingItem(name = name)
        )
    }

    fun deleteShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        deleteShoppingItemUseCase(shoppingItem)
    }

    fun setIsPurchased(shoppingItem: ShoppingItem) = viewModelScope.launch {
        setIsPurchasedUseCase(shoppingItem)
    }
}