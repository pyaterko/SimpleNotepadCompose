package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit.ToDoEditViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditToDoScreen(
    toDo: ItemToDo,
    toDoEditViewModel: ToDoEditViewModel,
    onBackPressed: () -> Unit,
) {

    val id:Int by toDoEditViewModel.id
    val title: String by toDoEditViewModel.title
    val description: String by toDoEditViewModel.description
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
        EditToDoScreenContent(title = title,
            onTitleChange = {
                toDoEditViewModel.title.value = it
            },
            description = description,
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
                bottom = 70.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Title") },
            value = title,
            onValueChange = {onTitleChange(it)},
            colors = myTextFieldColors())

        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            label = { Text(text = "Description") },
            value = description,
            onValueChange = {onDescriptionChange(it)},
            textStyle = MaterialTheme.typography.body2,
            colors = myTextFieldColors())

    }
}


@Composable
fun myTextFieldColors(): TextFieldColors {
    return TextFieldDefaults.textFieldColors(
        textColor = Color.Black,
        disabledTextColor = Color.Black,
        backgroundColor = Color.White,
        cursorColor = Color.Blue,
        errorCursorColor = Color.Red,
        unfocusedLabelColor = Color.Gray,
        focusedLabelColor = Color.Blue,
        leadingIconColor = Color.Red,
        focusedIndicatorColor = Color.Blue,
        unfocusedIndicatorColor = Color.Gray,
        errorIndicatorColor = Color.Red,
        disabledIndicatorColor = Color.Red,
        disabledLeadingIconColor = Color.Red,
        errorLeadingIconColor = Color.Red,
        trailingIconColor = Color.Blue,
        disabledTrailingIconColor = Color.Red,
        errorTrailingIconColor = Color.Red,
        disabledLabelColor = Color.Red,
        errorLabelColor = Color.Blue,
        placeholderColor = Color.Blue,
        disabledPlaceholderColor = Color.Blue,
    )
}

@Preview
@Composable
fun EditToDoScreenContentPreview() {
    EditToDoScreenContent(
        title = "Dermo",
        onTitleChange = {},
        description = "Ebobo",
        onDescriptionChange = {}
    )
}