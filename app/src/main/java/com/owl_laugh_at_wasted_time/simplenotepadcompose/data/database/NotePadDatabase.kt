package com.owl_laugh_at_wasted_time.simplenotepadcompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.dao.ItemNoteDao
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.dao.ShoppingDao
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.dao.ToDoDao
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty.ItemNoteDbModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty.ItemShoppingDbModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty.ItemToDoDbModel


@Database(
    entities = [
        ItemToDoDbModel::class,
        ItemShoppingDbModel::class,
        ItemNoteDbModel::class
    ], version = 1, exportSchema = false
)
abstract class NotePadDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
    abstract fun shoppingDao(): ShoppingDao
    abstract fun noteDao(): ItemNoteDao
}