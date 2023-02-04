package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation.NavigationState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ListToDoScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListScreenState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListViewModel


@Composable
fun ToDoScreen(
    navigationState: NavigationState,
    toDoListViewModel: ToDoListViewModel,
    onItemClickListener: (ItemToDo) -> Unit,
    editTodo: () -> Unit,
) {
    val screenState = toDoListViewModel.listState.observeAsState(ToDoListScreenState.Initial)

    when (screenState.value) {
        is ToDoListScreenState.ToDoList -> {
            ListToDoScreen(
                navigationState,
                toDoListViewModel,
                screenState.value,
                onItemClickListener,

                )
            { editTodo() }
        }

        ToDoListScreenState.Initial -> {}
    }
}

