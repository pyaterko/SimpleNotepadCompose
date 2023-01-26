package com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.toDoNavGraph (
    toDoListScreenContent: @Composable () -> Unit,
    toDoEditScreenContent: @Composable () -> Unit,
){
    navigation(
        startDestination = Screen.ToDoList.route,
        route = Screen.ToDo.route
    ) {
        composable(Screen.ToDoList.route) {
            toDoListScreenContent()
        }
        composable(Screen.ToDoEdit.route){
            toDoEditScreenContent()
        }
    }
}