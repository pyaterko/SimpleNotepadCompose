package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.NotesScreenAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListNoteScreen(
    editNote:() -> Unit
) {
    Scaffold(
        modifier = Modifier.padding(bottom = 48.dp),
        topBar = {
            NotesScreenAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {editNote()}
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) {
        Text(text = "Notes")
    }
}