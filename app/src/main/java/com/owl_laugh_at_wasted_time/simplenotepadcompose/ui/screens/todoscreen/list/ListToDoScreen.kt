@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation.NavigationState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.ToDoScreenAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListToDoScreen(
    navigationState: NavigationState,
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
        ListTodo(navigationState, state, onItemClickListener, toDoListViewModel)
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
private fun ListTodo(
    navigationState: NavigationState,
    state: ToDoListScreenState,
    onItemClickListener: (ItemToDo) -> Unit,
    toDoListViewModel: ToDoListViewModel,
) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 4.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 50.dp
        ),
    ) {
        when (state) {
            is ToDoListScreenState.ToDoList -> {
                itemsIndexed(state.list, key = { _, item -> item.key }) { _, item ->
                    val dismissState = rememberDismissState()
                    val dismissDirection = dismissState.dismissDirection
                    val isDismissedToDelete = dismissState.isDismissed(DismissDirection.EndToStart)
                    val isDismissedToEdit = dismissState.isDismissed(DismissDirection.StartToEnd)

                    if (isDismissedToDelete && dismissDirection == DismissDirection.EndToStart) {
                        toDoListViewModel.delete(item)
                    } else if (isDismissedToEdit && dismissDirection == DismissDirection.StartToEnd) {
                        navigationState.editToDo(item)

                    }

                    val degrees by animateFloatAsState(
                        targetValue = when (dismissState.targetValue) {
                            DismissValue.Default -> 0f
                            DismissValue.DismissedToEnd -> -90f
                            DismissValue.DismissedToStart -> -45f
                        }
                    )

                    SwipeToDismiss(
                        modifier = Modifier.animateItemPlacement(),
                        state = dismissState,
                        directions = setOf(
                            DismissDirection.EndToStart,
                            DismissDirection.StartToEnd
                        ),
                        dismissThresholds = { FractionalThreshold(fraction = 0.3f) },
                        background = {
                            when (dismissDirection) {
                                DismissDirection.StartToEnd -> EditBackground(degrees = degrees)
                                DismissDirection.EndToStart -> DeleteBackground(degrees = degrees)
                                null -> Color.Transparent
                            }
                        },
                        dismissContent = {
                            ToDoItem(
                                item = item,
                                onItemClickListener = onItemClickListener,
                            )
                        }
                    )


                }
            }
            ToDoListScreenState.Initial -> {}
        }

    }
}


@Composable
fun DeleteBackground(degrees: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(Color.Red.copy(alpha = 0.3f)),
        contentAlignment = Alignment.CenterEnd
    )
    {
        Row {
            Text(
                text = "DELETE",
                Modifier.padding(end = 10.dp),
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .rotate(degrees),
                imageVector = Icons.Filled.Delete,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
fun EditBackground(degrees: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(Color.Blue.copy(alpha = 0.3f)),
        contentAlignment = Alignment.CenterStart
    )
    {
        Row {
            Icon(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .rotate(degrees),
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "Edit",
                Modifier.padding(start = 10.dp),
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}