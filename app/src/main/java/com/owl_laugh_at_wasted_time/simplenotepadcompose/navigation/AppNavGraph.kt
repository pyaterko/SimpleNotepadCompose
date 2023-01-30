package com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    toDoListScreenContent: @Composable () -> Unit,
    toDoEditScreenContent: @Composable (ItemToDo) -> Unit,
    notesListScreenContent: @Composable () -> Unit,
    noteEditScreenContent: @Composable (ItemNote) -> Unit,
    shopScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ToDo.route
    ) {
        toDoNavGraph(toDoListScreenContent, toDoEditScreenContent)
        notesNavGraph(notesListScreenContent, noteEditScreenContent)
        composable(Screen.Shop.route) {
            shopScreenContent()
        }
    }
}