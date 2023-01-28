package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.ToDoScreenAppBar
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen.ShopItem
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen.ShoppingListScreenState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit.ToDoItem
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListScreenState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListToDoScreen(
    toDoListViewModel:ToDoListViewModel,
    state: ToDoListScreenState,
    editTodo:() -> Unit) {
    Scaffold(
        modifier = Modifier.padding(bottom = 48.dp),
        topBar = {
            ToDoScreenAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {editTodo()}
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 38.dp,
                    start = 8.dp,
                    end = 8.dp
                )
        ) {
            when (state) {
                is ToDoListScreenState.ToDoList-> {
                    val list = state.list
                    items(list.size) { index ->
                    ToDoItem(toDoItem = list[index],
                        onClickDeleteIcon = {
                            toDoListViewModel.delete(list[index])
                        })
                    }
                }
                ToDoListScreenState.Initial -> {}
            }

        }
    }
}