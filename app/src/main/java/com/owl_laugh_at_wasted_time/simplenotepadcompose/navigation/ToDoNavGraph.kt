package com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.gson.Gson
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

fun NavGraphBuilder.toDoNavGraph(
    toDoListScreenContent: @Composable () -> Unit,
    toDoEditScreenContent: @Composable (ItemToDo) -> Unit,
) {
    navigation(
        startDestination = Screen.ToDoList.route,
        route = Screen.ToDo.route
    ) {
        composable(Screen.ToDoList.route) {
            toDoListScreenContent()
        }
        composable(
            route = Screen.ToDoEdit.route,
            arguments = listOf(
            navArgument(Screen.ITEM_TODO){
                type= NavType.StringType
            }
            )
        ) {
            val itemToDoGson= it.arguments?.getString(Screen.ITEM_TODO) ?: ""
            val itemToDo=Gson().fromJson(itemToDoGson,ItemToDo::class.java)
            toDoEditScreenContent(itemToDo)
        }
    }
}