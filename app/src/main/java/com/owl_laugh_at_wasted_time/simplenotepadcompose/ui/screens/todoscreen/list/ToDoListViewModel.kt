package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {


    val listState =
        repository.getAllData()
            .map { ToDoListScreenState.ToDoList(it) as ToDoListScreenState }
            .onStart { ToDoListScreenState.Initial }
            .asLiveData()


    fun add(toDo: ItemToDo) {
        viewModelScope.launch {
            repository.add(toDo)
        }
    }

    fun delete(toDo: ItemToDo) {
        viewModelScope.launch {
            repository.delete(toDo)
        }
    }

}