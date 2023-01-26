package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list

import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote

sealed class NotesListScreenState {
    object Initial : NotesListScreenState()
    data class ListNotes(val list: List<ItemNote>) : NotesListScreenState()
}