package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.ToDoScreenAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListToDoScreen(
    toDoListViewModel: ToDoListViewModel,
    state: ToDoListScreenState,
    onItemClickListener: (ItemToDo) -> Unit,
    editTodo: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.padding(bottom = 48.dp),
        topBar = {
            ToDoScreenAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { editTodo() }
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) {
        ListTodo(state, onItemClickListener, toDoListViewModel)
    }
}

@Composable
private fun ListTodo(
    state: ToDoListScreenState,
    onItemClickListener: (ItemToDo) -> Unit,
    toDoListViewModel: ToDoListViewModel,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        when (state) {
            is ToDoListScreenState.ToDoList -> {
                itemsIndexed(state.list) { _, item ->
                    ToDoItem(
                        item = item,
                        onItemClickListener = onItemClickListener,
                        onClickDeleteIcon = {
                            toDoListViewModel.delete(item)
                        })
                }
            }
            ToDoListScreenState.Initial -> {}
        }

    }
}