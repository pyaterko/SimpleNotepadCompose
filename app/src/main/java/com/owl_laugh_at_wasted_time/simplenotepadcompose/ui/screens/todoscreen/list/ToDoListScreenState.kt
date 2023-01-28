package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list

import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

sealed class ToDoListScreenState {
    object Initial: ToDoListScreenState()
    data class ToDoList(val list:List<ItemToDo>): ToDoListScreenState()
}