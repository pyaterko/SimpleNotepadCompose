package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit

import android.annotation.SuppressLint
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.myTextFieldColors


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditToDoScreen(
    toDo: ItemToDo,
    toDoEditViewModel: ToDoEditViewModel,
    onBackPressed: () -> Unit,
) {
    if (toDo.id != Constants.UNDEFINED_ID) {
        HandleBackButton(onBackPressed = { onBackPressed() })
    }

    val title = toDoEditViewModel.title
    val description = toDoEditViewModel.description
    toDoEditViewModel.id.value = toDo.id
    toDoEditViewModel.title.value = toDo.title
    toDoEditViewModel.description.value = toDo.data

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = toDo.dateOfCreation)
                },
                navigationIcon = {
                    IconButton(
                        onClick = { onBackPressed() }
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )

        }
    ) {
        EditToDoScreenContent(title = title.value,
            onTitleChange = {
                toDoEditViewModel.title.value = it
            },
            description = description.value,
            onDescriptionChange = {
                toDoEditViewModel.description.value = it
            })
    }
}

@Composable
fun EditToDoScreenContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(
                start = 8.dp,
                top = 8.dp,
                end = 8.dp,
                bottom = 70.dp
            )
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Title") },
            value = title,
            onValueChange = { onTitleChange(it) },
            colors = myTextFieldColors()
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            label = { Text(text = "Description") },
            value = description,
            onValueChange = { onDescriptionChange(it) },
            textStyle = MaterialTheme.typography.body2,
            colors = myTextFieldColors()
        )

    }
}

@Composable
fun HandleBackButton(
    backPressedDispatcher: OnBackPressedDispatcher? =
        LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
    onBackPressed: () -> Unit,
) {
    val currentOnBackPressed by rememberUpdatedState(newValue = (onBackPressed))

    val callback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher?.addCallback(callback)

        onDispose {
            callback.remove()
        }
    }
}

@Preview
@Composable
fun EditToDoScreenContentPreview() {
    EditToDoScreenContent(
        title = "title",
        onTitleChange = {},
        description = "description",
        onDescriptionChange = {}
    )
}