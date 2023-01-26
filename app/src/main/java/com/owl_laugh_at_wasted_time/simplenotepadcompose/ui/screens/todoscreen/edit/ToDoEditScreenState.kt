package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit

import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

sealed class ToDoEditScreenState {

    object Initial : ToDoEditScreenState()
    data class EditToDo(val itemToDo: ItemToDo) : ToDoEditScreenState()
}