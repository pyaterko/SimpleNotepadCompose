package com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity


import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.DATE_FORMAT_IN
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.UNDEFINED_ID
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

data class ItemToDo (
    var id: Int = UNDEFINED_ID,
    val key:Int=kotlin.random.Random.nextInt(),
    var title: String = "",
    var dateOfCreation: String = SimpleDateFormat(
        DATE_FORMAT_IN,
        Locale.getDefault()
    ).format(Date()),
    var data: String = "",
    var done: Boolean = false
)