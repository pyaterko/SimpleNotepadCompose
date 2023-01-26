package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit.EditNoteScreenState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit.EditNoteViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list.ListNoteScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListScreenState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.theme.SimpleNotepadComposeTheme


@Composable
fun NotesScreen(
    editNote: () -> Unit
) {
    val editNoteViewModel: EditNoteViewModel = viewModel()
    val screenState = editNoteViewModel.screenState.observeAsState(EditNoteScreenState.Initial)

    when (screenState.value) {
        is EditNoteScreenState.EditNote -> {
            ListNoteScreen { editNote() }
        }

        EditNoteScreenState.Initial -> {}
    }
}

@Preview
@Composable
private fun NotesScreenPreview() {
    SimpleNotepadComposeTheme {
        NotesScreen{}
    }

}