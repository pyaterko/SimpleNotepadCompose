package com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.DATABASE_TABLE_NOTE

@Entity(tableName = DATABASE_TABLE_NOTE)
data class ItemNoteDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val text: String,
    val dateOfCreation: String,
    val category: String
) {
    fun toItemNote() = ItemNote(
        id = id,
        title = title,
        text = text,
        dateOfCreation = dateOfCreation,
        category = category
    )

    companion object {
        fun fromItemNote(item: ItemNote) =
            ItemNoteDbModel(
                id = item.id,
                title = item.title,
                text = item.text,
                dateOfCreation = item.dateOfCreation,
                category = item.category
            )

    }
}