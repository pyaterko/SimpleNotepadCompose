package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.MyTextFieldColors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditNoteScreen(
    itemNote: ItemNote,
    editNoteViewModel: EditNoteViewModel,
    onBackPressed: () -> Unit,
) {

    val title = editNoteViewModel.title
    val description = editNoteViewModel.description
    editNoteViewModel.id.value = itemNote.id
    editNoteViewModel.title.value = itemNote.title
    editNoteViewModel.description.value = itemNote.text

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = itemNote.dateOfCreation)
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
        EditNoteScreenContent(
            title = title.value,
            onTitleChange = {
                editNoteViewModel.title.value = it
            },
            description = description.value,
            onDescriptionChange = {
                editNoteViewModel.description.value = it
            })
    }
}

@Composable
fun EditNoteScreenContent(
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
            onValueChange = { onTitleChange(it) },
            colors = MyTextFieldColors())

        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            label = { Text(text = "Description") },
            value = description,
            onValueChange = { onDescriptionChange(it) },
            textStyle = MaterialTheme.typography.body2,
            colors = MyTextFieldColors())

    }
}


@Preview
@Composable
fun EditNoteScreenContentPreview() {
    EditNoteScreenContent(
        title = "title",
        onTitleChange = {},
        description = "description",
        onDescriptionChange = {}
    )
}