package com.owl_laugh_at_wasted_time.simplenotepadcompose.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty.ItemShoppingDbModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingDao {
    @Query("SELECT * FROM ${Constants.DATABASE_TABLE_SHOPPING} ORDER BY done ASC")
    fun getAllData(): Flow<List<ItemShoppingDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(shoppingListItem: ItemShoppingDbModel)

    @Query("DELETE FROM ${Constants.DATABASE_TABLE_SHOPPING} WHERE id=:shoppingListItemId")
    suspend fun delete(shoppingListItemId: Int)
}