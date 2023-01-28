package com.owl_laugh_at_wasted_time.simplenotepadcompose.data.model

import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.dao.ToDoDao
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty.ItemToDoDbModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.ToDoRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class InToDoRepository @Inject constructor(
    private val data: ToDoDao
) : ToDoRepository {

    override fun getAllData() = runBlocking {
        val listFlow = data.getAllData()
        listFlow.map { items -> items.map { it.toItemToDo() } }
    }

    override suspend fun add(item: ItemToDo) {
        data.add(ItemToDoDbModel.fromItemToDo(item))
    }

    override suspend fun delete(item: ItemToDo) {
        data.delete(ItemToDoDbModel.fromItemToDo(item))
    }
}