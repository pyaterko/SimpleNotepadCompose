package com.owl_laugh_at_wasted_time.simplenotepadcompose.data.dao

import androidx.room.*
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty.ItemToDoDbModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE_TODO} ORDER BY id ASC")
    fun getAllData(): Flow<List<ItemToDoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(toDoNote: ItemToDoDbModel)

    @Delete
    suspend fun delete(toDoNote: ItemToDoDbModel)

    @Query("DELETE FROM ${Constants.DATABASE_TABLE_TODO}")
    suspend fun deleteAll()




}