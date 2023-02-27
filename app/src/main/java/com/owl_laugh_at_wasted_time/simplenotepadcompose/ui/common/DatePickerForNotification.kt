@file:Suppress("NAME_SHADOWING")

package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.common

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants.DATE_FORMAT_OUT
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun getDatePickerDialog(
    setNotification: (Long) -> Unit,
    setDateValueToItem: (String) -> Unit,
): DatePickerDialog {

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val timePickerDialog = TimePickerDialog(
        LocalContext.current,
        { _: TimePicker, hour: Int, minute: Int ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            val data = SimpleDateFormat(
                DATE_FORMAT_OUT,
                Locale.getDefault()
            ) .format(calendar.time)
            setNotification.invoke(calendar.time.time)
            setDateValueToItem.invoke(data)
        }, hour, minute, true
    )

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            timePickerDialog.show()
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month )

        }, year, month, day
    )
    return datePickerDialog
}