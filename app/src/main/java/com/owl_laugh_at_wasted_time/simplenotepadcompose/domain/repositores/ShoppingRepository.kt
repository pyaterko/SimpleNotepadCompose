package com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores

import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemShopping
import kotlinx.coroutines.flow.Flow

interface ShoppingRepository {
    fun getAllData(): Flow<List<ItemShopping>>
    suspend fun add(shoppingListItem: ItemShopping)
    suspend fun delete(shoppingListItemId: Int)
}
