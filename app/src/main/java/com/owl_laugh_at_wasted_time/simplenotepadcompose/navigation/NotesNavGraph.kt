package com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.gson.Gson
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

fun NavGraphBuilder.notesNavGraph (
  notesListScreenContent: @Composable () -> Unit,
   noteEditScreenContent: @Composable (ItemNote) -> Unit,
){
    navigation(
        startDestination = Screen.NotesList.route,
        route = Screen.Note.route
    ) {
        composable(
            route = Screen.NotesList.route
        )
            {
            notesListScreenContent()
        }
        composable(
            route = Screen.NoteEdit.route,
            arguments = listOf(
                navArgument(Screen.ITEM_NOTE)
                {
                    type= NavType.StringType
                })
        ){
            val itemToDoGson= it.arguments?.getString(Screen.ITEM_NOTE) ?: ""
            val itemNote=Gson().fromJson(itemToDoGson,ItemNote::class.java)
            noteEditScreenContent(itemNote)
        }
    }
}