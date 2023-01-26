package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class ToDoEditViewModel(
    private val toDo: ItemToDo
): ViewModel() {

    private val initialState = ToDoEditScreenState.EditToDo(ItemToDo())
    private var savedState: ToDoEditScreenState? = initialState

    private val _screenState = MutableLiveData<ToDoEditScreenState>(initialState)
    val screenState: LiveData<ToDoEditScreenState> = _screenState

    fun addToDo() {
        savedState = _screenState.value
        _screenState.value = ToDoEditScreenState.EditToDo(ItemToDo())
    }

    fun closeEdit() {
        _screenState.value = savedState
    }
}