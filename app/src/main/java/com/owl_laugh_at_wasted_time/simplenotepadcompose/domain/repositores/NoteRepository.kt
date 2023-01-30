package com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores

import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getLiveDate(): Flow<List<ItemNote>>
    suspend fun add(item: ItemNote)
    suspend fun delete(item: ItemNote)


}