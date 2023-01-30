package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.model.InNoteRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val repository: InNoteRepository,
) : ViewModel() {

    val listState =
        repository.getLiveDate()
            .map { NotesListScreenState.ListNotes(it) as NotesListScreenState }
            .onStart { NotesListScreenState.Initial }
            .asLiveData()


    fun delete(itemNote: ItemNote) {
        viewModelScope.launch {
            repository.delete(itemNote)
        }
    }


}