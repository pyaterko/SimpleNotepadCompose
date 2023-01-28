package com.owl_laugh_at_wasted_time.simplenotepadcompose.data.model

import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.dao.ShoppingDao
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty.ItemShoppingDbModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemShopping
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.ShoppingRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class InShopRepository @Inject constructor(
    private val data: ShoppingDao
) : ShoppingRepository {

    override fun getAllData() = runBlocking {
        val listFlow = data.getAllData()
        listFlow.map { items -> items.map { it.toItemShop() } }
    }

    override suspend fun add(shoppingListItem: ItemShopping) {
        data.add(ItemShoppingDbModel.fromItemShop(shoppingListItem))
    }

    override suspend fun delete(shoppingListItemId: Int) {
        data.delete(shoppingListItemId)
    }
}