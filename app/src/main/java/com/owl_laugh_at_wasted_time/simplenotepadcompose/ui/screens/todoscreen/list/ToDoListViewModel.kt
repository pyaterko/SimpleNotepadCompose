package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

class ToDoListViewModel : ViewModel() {

    private val initialState = ToDoListScreenState.ListToDoList(emptyList())

    private val _screenState = MutableLiveData<ToDoListScreenState>(initialState)
    val screenState: LiveData<ToDoListScreenState> = _screenState


}