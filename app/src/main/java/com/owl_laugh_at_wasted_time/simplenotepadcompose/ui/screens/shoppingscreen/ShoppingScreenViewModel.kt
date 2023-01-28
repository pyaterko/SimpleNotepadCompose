package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.InShopRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemShopping
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingScreenViewModel @Inject constructor(
    private val repository: ShoppingRepository
) : ViewModel() {

    private val _listItems = MutableLiveData<List<ItemShopping>>()
    val listItemShopping: MutableLiveData<List<ItemShopping>> = _listItems

    private val list = repository.getAllData()

    init {
        viewModelScope.launch {
            list.collect {
                _listItems.postValue(it)
            }
        }
    }

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