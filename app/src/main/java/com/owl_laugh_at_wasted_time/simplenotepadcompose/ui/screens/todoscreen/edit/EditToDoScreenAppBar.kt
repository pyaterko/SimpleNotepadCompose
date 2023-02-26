package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.common.setDateOfNotification
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.theme.SimpleNotepadComposeTheme
import java.util.*
@Composable
@Suppress("NAME_SHADOWING")
fun EditToDoScreenAppBar(
    notificationIcon:Boolean,
    text: String,
    onClickDone: () -> Unit,
    onClickDelete: () -> Unit,
    setNotification:(Long)->Unit,
    onBackPressed: () -> Unit,
) {
    val datePickerDialog = setDateOfNotification(){
        setNotification(it)
    }
    TopAppBar(
        title = {
            Text(text = text)
        },
        navigationIcon = {
            IconButton(
                onClick = { onBackPressed() }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            if (notificationIcon) {
                IconButton(onClick = {
                   datePickerDialog.show()
                }) {
                    Icon(
                        Icons.Filled.Notifications,
                        contentDescription = null
                    )
                }
                IconButton(onClick = {
                    onClickDelete()
                }) {
                    Icon(
                        Icons.Filled.Delete,
                        contentDescription = null
                    )
                }
            }
            IconButton(onClick = {
                onClickDone()
            }) {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = null
                )
            }

        }
    )
}




@Preview
@Composable
fun MainScreenAppBarPreview() {
    SimpleNotepadComposeTheme(false) {
        EditToDoScreenAppBar(true,
            "10:12:63", {}, {}, {},{}
        )
    }

}