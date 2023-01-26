package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListScreenState


@Composable
fun ToDoScreen(
    editTodo:() -> Unit
) {
    val toDoListViewModel:ToDoListViewModel= viewModel()
    val screenState = toDoListViewModel.screenState.observeAsState(ToDoListScreenState.Initial)

    when (screenState.value) {
        is ToDoListScreenState.ListToDoList -> {
            ListToDoScreen{editTodo()}
        }

        ToDoListScreenState.Initial -> {}
    }
}

