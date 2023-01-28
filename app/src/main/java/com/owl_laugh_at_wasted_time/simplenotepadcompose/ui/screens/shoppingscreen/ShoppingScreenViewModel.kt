package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemShopping
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.ShoppingRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingScreenViewModel @Inject constructor(
    private val repository: ShoppingRepository
) : ViewModel() {

    val listState =
        repository.getAllData()
            .map { ShoppingListScreenState.ShopList(it) as ShoppingListScreenState }
            .onStart { ToDoListScreenState.Initial }
            .asLiveData()

    fun add(shoppingListItem: ItemShopping) {
        viewModelScope.launch {
            repository.add(shoppingListItem)
        }
    }

    fun delete(item: ItemShopping) {
        viewModelScope.launch {
            repository.delete(item.id)
        }
    }
}