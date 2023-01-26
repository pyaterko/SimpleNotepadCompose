package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

class EditNoteViewModel : ViewModel() {

    private val initialState = EditNoteScreenState.EditNote(ItemNote())

    private val _screenState = MutableLiveData<EditNoteScreenState>(initialState)
    val screenState: LiveData<EditNoteScreenState> = _screenState


}