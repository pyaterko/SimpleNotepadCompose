package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

class NotesListViewModel : ViewModel() {

    private val initialState = NotesListScreenState.ListNotes(emptyList())

    private val _screenState = MutableLiveData<NotesListScreenState>(initialState)
    val screenState: LiveData<NotesListScreenState> = _screenState


}