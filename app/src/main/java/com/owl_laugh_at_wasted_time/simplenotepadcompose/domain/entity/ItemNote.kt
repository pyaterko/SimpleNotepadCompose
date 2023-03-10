package com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity


import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.DATE_FORMAT_IN
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.UNDEFINED_ID
import java.text.SimpleDateFormat
import java.util.*


data class ItemNote(
    var id: Int = UNDEFINED_ID,
    var title: String = "",
    var text: String = "",
    var dateOfCreation: String = SimpleDateFormat(
        DATE_FORMAT_IN,
        Locale.getDefault()
    ).format(Date()),
    var category: String = ""
)