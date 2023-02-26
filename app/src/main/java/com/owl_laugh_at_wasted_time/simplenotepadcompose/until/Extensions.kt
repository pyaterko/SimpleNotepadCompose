package com.owl_laugh_at_wasted_time.simplenotepadcompose.until

import android.content.Intent
import android.provider.CalendarContract
import androidx.activity.ComponentActivity

fun ComponentActivity.addEvent(title: String, begin: Long) {
    val intent = Intent(Intent.ACTION_INSERT).apply {
        data = CalendarContract.Events.CONTENT_URI
        putExtra(CalendarContract.Events.TITLE, title)
        putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
    }
        startActivity(intent)
}