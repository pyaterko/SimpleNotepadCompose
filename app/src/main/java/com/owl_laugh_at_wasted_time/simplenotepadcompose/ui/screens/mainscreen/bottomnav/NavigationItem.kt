package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.owl_laugh_at_wasted_time.simplenotepadcompose.R
import com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val title: Int,
    val icon: ImageVector
) {
    object ToDoItem : NavigationItem(
        screen = Screen.ToDo,
        title = R.string.nav_item_todo,
        icon = Icons.Outlined.Home
    )

    object NotesItem : NavigationItem(
        screen = Screen.Note,
        title = R.string.nav_item_notes,
        icon = Icons.Outlined.Edit
    )

    object ShoppingItem : NavigationItem(
        screen = Screen.Shop,
        title = R.string.nav_item_shopping,
        icon = Icons.Outlined.ShoppingCart
    )

}
