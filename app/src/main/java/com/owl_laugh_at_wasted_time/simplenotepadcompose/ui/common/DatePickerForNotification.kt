@file:Suppress("NAME_SHADOWING")

package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.common

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.util.*

@Composable
fun setDateOfNotification(setNotification: (Long) -> Unit): DatePickerDialog {

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    // calendar.time = Date()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val date = remember { mutableStateOf("") }
    val time = remember { mutableStateOf("") }

    val timePickerDialog = TimePickerDialog(
        LocalContext.current,
        { _: TimePicker, hour: Int, minute: Int ->
            setNotification.invoke(calendar.time.time)
        }, hour, minute, true
    )

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            timePickerDialog.show()
            date.value = "$dayOfMonth/${month + 1}/$year"
        }, year, month, day
    )
    return datePickerDialog
}