package com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    toDoListScreenContent: @Composable () -> Unit,
    toDoEditScreenContent: @Composable () -> Unit,
    notesListScreenContent: @Composable () -> Unit,
    noteEditScreenContent: @Composable () -> Unit,
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