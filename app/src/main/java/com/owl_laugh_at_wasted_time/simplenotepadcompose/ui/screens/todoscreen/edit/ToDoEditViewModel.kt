package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.model.InToDoRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.UNDEFINED_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ToDoEditViewModel @Inject constructor(
    private val repository: InToDoRepository,
) : ViewModel() {

    val id: MutableState<Int> = mutableStateOf(0)
    val title: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("")

    fun onBack(itemToDo: ItemToDo) {
        viewModelScope.launch {
            if (itemToDo.id !=UNDEFINED_ID){
                repository.add(itemToDo)
            }
        }
    }

    fun add() {
        viewModelScope.launch {
            repository.add(
                ItemToDo(
                    id = id.value,
                    key = Random.nextInt(Int.MAX_VALUE),
                    title = title.value,
                    data = description.value
                )
            )
        }
    }

    fun delete(toDo: ItemToDo) {
        viewModelScope.launch {
            repository.delete(toDo)
        }
    }

}