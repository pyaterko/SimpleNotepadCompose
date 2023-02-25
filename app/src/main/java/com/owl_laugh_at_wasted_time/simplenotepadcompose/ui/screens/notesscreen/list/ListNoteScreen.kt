package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.common.FabOnTheListScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.NotesScreenAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListNoteScreen(
    state: NotesListScreenState,
    onItemClickListener: (ItemNote) -> Unit,
    notesListViewModel: NotesListViewModel,
    editNote: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.padding(bottom = 48.dp),
        topBar = {
            NotesScreenAppBar()
        }
    ) {
        ListNotes(state, notesListViewModel, onItemClickListener, editNote)
    }
}

@Composable
private fun ListNotes(
    state: NotesListScreenState,
    notesListViewModel: NotesListViewModel,
    onItemClickListener: (ItemNote) -> Unit,
    editNote: () -> Unit,
) {
    Surface(Modifier.fillMaxSize()) {
        val lazyState = rememberLazyListState()
        LazyColumn(
            state = lazyState,
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
        FabOnTheListScreen(
            lazyState,
            Modifier
                .padding(bottom = 12.dp)
                .wrapContentSize(align = Alignment.BottomEnd)
        ) {
            editNote()
        }
    }
}