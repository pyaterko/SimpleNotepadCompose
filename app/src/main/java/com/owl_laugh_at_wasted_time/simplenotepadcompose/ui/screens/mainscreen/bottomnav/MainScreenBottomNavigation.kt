package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.bottomnav.NavigationItem
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.theme.SimpleNotepadComposeTheme

@Composable
fun MainScreenBottomNavigation() {
    BottomNavigation(

    ) {
        val selectedItemPosition= remember {
            mutableStateOf(0)
        }
        val items =
            listOf(
                NavigationItem.ToDoItem,
                NavigationItem.NotesItem,
                NavigationItem.ShoppingItem
            )
        items.forEachIndexed { index, navigationItem ->
            BottomNavigationItem(
                selected = selectedItemPosition.value==index,
                onClick = {
                          selectedItemPosition.value=index
                },
                icon = {
                    Icon(
                        navigationItem.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = navigationItem.title)
                    )
                },
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = MaterialTheme.colors.onSecondary
            )
        }

    }
}

@Preview
@Composable
private fun MainScreenBottomNavigationPreviewLight() {
    SimpleNotepadComposeTheme(
        darkTheme = false
    ) {
        MainScreenBottomNavigation()
    }

}

@Preview
@Composable
private fun MainScreenBottomNavigationPreviewDark() {
    SimpleNotepadComposeTheme(
        darkTheme = true
    ) {
        MainScreenBottomNavigation()
    }

}