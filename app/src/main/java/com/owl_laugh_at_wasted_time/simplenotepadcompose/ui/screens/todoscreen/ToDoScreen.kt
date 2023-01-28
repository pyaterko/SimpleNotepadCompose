package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListScreenState


@Composable
fun ToDoScreen(
    toDoListViewModel:ToDoListViewModel,
    editTodo:() -> Unit
) {
    val screenState = toDoListViewModel.listState.observeAsState(ToDoListScreenState.Initial)

    when (screenState.value) {
        is ToDoListScreenState.ToDoList -> {
            ListToDoScreen(toDoListViewModel,screenState.value){editTodo()}
        }

        ToDoListScreenState.Initial -> {}
    }
}

