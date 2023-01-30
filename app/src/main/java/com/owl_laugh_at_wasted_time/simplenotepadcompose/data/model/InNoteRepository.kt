package com.owl_laugh_at_wasted_time.simplenotepadcompose.data.model

import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.dao.ItemNoteDao
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty.ItemNoteDbModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.NoteRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class InNoteRepository @Inject constructor(
    private val data: ItemNoteDao,
) : NoteRepository {

    override fun getLiveDate() = runBlocking {
        val listFlow = data.getAllData()
        listFlow.map { items -> items.map { it.toItemNote() } }
    }

    override suspend fun add(item: ItemNote) {
        data.add(ItemNoteDbModel.fromItemNote(item))
    }

    override suspend fun delete(item: ItemNote) {
        data.delete(item.id)
    }
}