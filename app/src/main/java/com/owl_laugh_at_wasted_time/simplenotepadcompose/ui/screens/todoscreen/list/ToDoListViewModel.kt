package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val repository: ToDoRepository,
) : ViewModel() {

    val undoDeleteItemToDo: MutableState<ItemToDo> = mutableStateOf(ItemToDo())

    val listState =
        repository.getAllData()
            .map { ToDoListScreenState.ToDoList(it) as ToDoListScreenState }
            .onStart { ToDoListScreenState.Initial }
            .asLiveData()
    fun delete(toDo: ItemToDo) {
        undoDeleteItemToDo.value = toDo
        viewModelScope.launch {
            repository.delete(toDo)
        }
    }
    fun add() {
        viewModelScope.launch { repository.add((undoDeleteItemToDo.value).copy(key = Random.nextInt(Int.MAX_VALUE))) }
    }
}