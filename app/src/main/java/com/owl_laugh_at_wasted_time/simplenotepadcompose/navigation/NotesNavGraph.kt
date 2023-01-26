package com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.notesNavGraph (
  notesListScreenContent: @Composable () -> Unit,
   noteEditScreenContent: @Composable () -> Unit,
){
    navigation(
        startDestination = Screen.NotesList.route,
        route = Screen.Note.route
    ) {
        composable(Screen.NotesList.route) {
            notesListScreenContent()
        }
        composable(Screen.NoteEdit.route){
            noteEditScreenContent()
        }
    }
}