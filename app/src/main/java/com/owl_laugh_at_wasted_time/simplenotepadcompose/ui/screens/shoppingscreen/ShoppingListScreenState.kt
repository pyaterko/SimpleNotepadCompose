package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen

import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemShopping

sealed class ShoppingListScreenState {
    object Initial: ShoppingListScreenState()
    data class ShopList(val list:List<ItemShopping>): ShoppingListScreenState()
}