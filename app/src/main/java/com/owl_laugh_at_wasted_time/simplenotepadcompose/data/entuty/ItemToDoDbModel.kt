package com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.DATABASE_TABLE_TODO

@Entity(tableName = DATABASE_TABLE_TODO)
data class ItemToDoDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val key:Int,
    val title: String,
    val dateOfCreation: String,
    var data: String,
    var done: Boolean
) {
    fun toItemToDo() = ItemToDo(
        id = id,
        key=key,
        title = title,
        done = done,
        dateOfCreation = dateOfCreation,
        data = data
    )

    companion object {
        fun fromItemToDo(item: ItemToDo) =
            ItemToDoDbModel(
                id = item.id,
                key=item.key,
                title = item.title,
                done = item.done,
                dateOfCreation = item.dateOfCreation,
                data = item.data
            )

    }
}