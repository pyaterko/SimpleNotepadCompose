package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit

import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote

sealed class EditNoteScreenState {

    object Initial : EditNoteScreenState()
    data class EditNote(val item: ItemNote) : EditNoteScreenState()
}