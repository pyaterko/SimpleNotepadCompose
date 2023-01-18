package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.owl_laugh_at_wasted_time.simplenotepadcompose.R

sealed class NavigationItem(
    val title: Int,
    val icon: ImageVector
) {
    object ToDoItem : NavigationItem(
        title = R.string.nav_item_todo,
        icon = Icons.Outlined.Home
    )

    object NotesItem : NavigationItem(
        title = R.string.nav_item_notes,
        icon = Icons.Outlined.Edit
    )

    object ShoppingItem : NavigationItem(
        title = R.string.nav_item_shopping,
        icon = Icons.Outlined.ShoppingCart
    )

}
