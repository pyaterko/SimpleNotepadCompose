package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.bottomnav

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation.NavigationState

@Composable
fun MainScreenBottomNavigation(
    navigationState: NavigationState
) {
    BottomNavigation {
        val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
        val items =
            listOf(
                NavigationItem.ToDoItem,
                NavigationItem.NotesItem,
                NavigationItem.ShoppingItem
            )
        items.forEach { navigationItem ->
            val selected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == navigationItem.screen.route
            } ?: false
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    if(!selected){
                        navigationState.navigateTo(navigationItem.screen.route)
                    }

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
