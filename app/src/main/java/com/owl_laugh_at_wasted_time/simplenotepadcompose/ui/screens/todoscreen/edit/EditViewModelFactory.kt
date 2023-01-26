package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

class EditViewModelFactory(
    val toDo: ItemToDo
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ToDoEditViewModel(toDo) as T
    }
}