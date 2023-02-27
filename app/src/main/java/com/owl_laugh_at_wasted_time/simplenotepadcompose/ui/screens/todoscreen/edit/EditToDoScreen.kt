package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit

import android.annotation.SuppressLint
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.myTextFieldColors
import java.util.*
import kotlin.random.Random


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditToDoScreen(
    toDo: ItemToDo,
    toDoEditViewModel: ToDoEditViewModel,
    setNotification: (String, Long) -> Unit,
    onBackPressed: () -> Unit,
) {

    val itemWhenMovingBack = toDo.copy(key = Random.nextInt(Int.MAX_VALUE))
    val title = toDoEditViewModel.title
    val description = toDoEditViewModel.description
    toDoEditViewModel.id.value = toDo.id
    toDoEditViewModel.title.value = toDo.title
  //  toDoEditViewModel.description.value = toDo.data
    val m = remember {
        mutableStateOf(false)
    }
    if (toDo.id != Constants.UNDEFINED_ID) {
        HandleBackButton(onBackPressed = {
            toDoEditViewModel.onBack(itemWhenMovingBack)
            onBackPressed()
        })
    }
    Scaffold(
        topBar = {
            EditToDoScreenAppBar(
                notificationIcon = toDo.title != "",
                text = toDo.dateOfCreation,
                onClickDone = {
                    toDoEditViewModel.add()
                    onBackPressed()
                },
                onClickDelete = {
                    toDoEditViewModel.delete(toDo)
                    onBackPressed()
                },
                setNotification = {
                    setNotification(toDo.title, it)
                },
                setDateValueToItem = {
                    toDoEditViewModel.description.value = it
                },
                onBackPressed = {
                    toDoEditViewModel.onBack(itemWhenMovingBack)
                    onBackPressed()
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
                //  toDoEditViewModel.description.value = it
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