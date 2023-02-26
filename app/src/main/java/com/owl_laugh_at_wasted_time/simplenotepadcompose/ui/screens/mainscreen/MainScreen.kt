package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation.AppNavGraph
import com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation.rememberNavigationState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.bottomnav.MainScreenBottomNavigation
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.NotesScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit.EditNoteScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit.EditNoteViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list.NotesListViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen.ShoppingScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen.ShoppingScreenViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit.EditToDoScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit.ToDoEditViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ListToDoScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListScreenState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    shopViewModel: ShoppingScreenViewModel,
    toDoListViewModel: ToDoListViewModel,
    toDoEditViewModel: ToDoEditViewModel,
    notesListViewModel: NotesListViewModel,
    editNoteViewModel: EditNoteViewModel,
    setNotification: (String, Long) -> Unit,
) {
    val screenState = toDoListViewModel.listState.observeAsState(ToDoListScreenState.Initial)
    val navigationState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            MainScreenBottomNavigation(navigationState)
        }

    ) {

        AppNavGraph(
            navHostController = navigationState.navHostController,
            toDoListScreenContent = {
                ListToDoScreen(
                    navigationState = navigationState,
                    toDoListViewModel = toDoListViewModel,
                    state = screenState.value,
                    onItemClickListener = {

                    },
                    editTodo = {
                        navigationState.editToDo(ItemToDo())
                    }
                )
            },
            toDoEditScreenContent = { item ->
                EditToDoScreen(
                    toDo = item,
                    toDoEditViewModel = toDoEditViewModel,
                    setNotification = setNotification
                ) {
                    navigationState.navHostController.popBackStack()
                }
            },
            notesListScreenContent = {
                NotesScreen(
                    notesListViewModel = notesListViewModel,
                    onItemClickListener = {
                        navigationState.editNote(it)
                    }) {
                    navigationState.editNote(ItemNote())
                }
            },
            noteEditScreenContent = { item ->
                EditNoteScreen(
                    itemNote = item,
                    editNoteViewModel = editNoteViewModel
                ) {
                    editNoteViewModel.add()
                    navigationState.navHostController.popBackStack()
                }
            },
            shopScreenContent = { ShoppingScreen(shopViewModel = shopViewModel) })

    }
}

