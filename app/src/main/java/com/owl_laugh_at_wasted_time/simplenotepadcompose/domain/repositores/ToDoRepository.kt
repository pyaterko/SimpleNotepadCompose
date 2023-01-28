package com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores

import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    fun getAllData(): Flow<List<ItemToDo>>
    suspend fun add(item: ItemToDo)
    suspend fun delete(item: ItemToDo)

}