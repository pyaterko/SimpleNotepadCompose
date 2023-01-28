package com.owl_laugh_at_wasted_time.simplenotepadcompose.data.entuty

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemShopping
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.DATABASE_TABLE_SHOPPING

@Entity(tableName = DATABASE_TABLE_SHOPPING)
data class ItemShoppingDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val productName: String,
    var done: Boolean
) {
    fun toItemShop() = ItemShopping(
        id = id,
        productName = productName,
        done = done
    )

    companion object {
        fun fromItemShop(item: ItemShopping) =
            ItemShoppingDbModel(
                id = item.id,
                productName = item.productName,
                done = item.done
            )

    }
}