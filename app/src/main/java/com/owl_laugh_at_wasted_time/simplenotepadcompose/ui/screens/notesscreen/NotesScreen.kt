package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen

import android.widget.AdapterView.OnItemClickListener
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list.ListNoteScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list.NotesListScreenState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list.NotesListViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.theme.SimpleNotepadComposeTheme


@Composable
fun NotesScreen(
    notesListViewModel: NotesListViewModel,
    onItemClickListener:(ItemNote)->Unit,
    editNote: () -> Unit,
) {
    val screenState = notesListViewModel.listState.observeAsState(NotesListScreenState.Initial)

    when (screenState.value) {
        is NotesListScreenState.ListNotes -> {
            ListNoteScreen(
                screenState.value,
                onItemClickListener ,
                notesListViewModel
            ) { editNote() }
        }
        NotesListScreenState.Initial -> {}
    }
}

