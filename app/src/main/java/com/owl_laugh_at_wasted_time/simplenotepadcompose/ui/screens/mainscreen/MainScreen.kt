package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation.AppNavGraph
import com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation.rememberNavigationState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.bottomnav.MainScreenBottomNavigation
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.NotesScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen.ShoppingScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit.EditNoteScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen.ShoppingScreenViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.EditToDoScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.ToDoScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    shopViewModel: ShoppingScreenViewModel,
    toDoListViewModel: ToDoListViewModel
) {
    val navigationState = rememberNavigationState()
    Scaffold(
        bottomBar = {
            MainScreenBottomNavigation(navigationState)
        }

    ) {
        AppNavGraph(
            navHostController = navigationState.navHostController,
            toDoListScreenContent = {
                ToDoScreen (toDoListViewModel){
                    navigationState.editToDo()
                }
            },
            toDoEditScreenContent = {
                EditToDoScreen(toDo = ItemToDo()) {
                    navigationState.navHostController.popBackStack()
                }
            },
            notesListScreenContent = {
                NotesScreen {
                    navigationState.editNote()
                }
            },
            noteEditScreenContent = {
                EditNoteScreen {
                    navigationState.navHostController.popBackStack()
                }
            },
            shopScreenContent = { ShoppingScreen(shopViewModel = shopViewModel) })

    }
}

