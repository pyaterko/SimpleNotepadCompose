package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.NotesScreenAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListNoteScreen(
    state: NotesListScreenState,
    onItemClickListener:(ItemNote)->Unit,
    notesListViewModel: NotesListViewModel,
    editNote: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.padding(bottom = 48.dp),
        topBar = {
            NotesScreenAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { editNote() }
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) {
        ListNotes(state, notesListViewModel,onItemClickListener)
    }
}

@Composable
private fun ListNotes(
    state: NotesListScreenState,
    notesListViewModel: NotesListViewModel,
    onItemClickListener:(ItemNote)->Unit,
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
            is NotesListScreenState.ListNotes -> {
                val list = state.list
                items(list.size) { index ->
                    NoteItem(
                        itemNote = list[index],
                        onItemClickListener = onItemClickListener,
                        onClickDeleteIcon = {
                            notesListViewModel.delete(it)
                        })
                }
            }
            NotesListScreenState.Initial -> {}
        }
    }
}