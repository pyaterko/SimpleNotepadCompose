package com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity

import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.UNDEFINED_ID


data class ItemShopping(
    val id: Int = UNDEFINED_ID,
    val productName: String = "bread",
    var done: Boolean = false
)
