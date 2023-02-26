package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.theme.SimpleNotepadComposeTheme

@Composable
fun ToDoScreenAppBar() {
    val isLiked = remember { mutableStateOf(false) }
    val result = remember { mutableStateOf("") }
    val expanded = remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(text = "ToDo")
        },
        actions = {
            IconButton(onClick = {

            }) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = null
                )
            }
            IconToggleButton(
                checked = isLiked.value,
                onCheckedChange = {
                    isLiked.value = it
                    if (isLiked.value) {
                        result.value = "Liked"

                    } else {
                        result.value = "Unliked"

                    }
                }
            ) {
                val tint by animateColorAsState(
                    if (isLiked.value) Color.Blue
                    else Color.Red
                )
                Icon(
                    Icons.Filled.Done,
                    contentDescription = null,

                )
            }

            Box(
                Modifier
                    .wrapContentSize(Alignment.TopEnd)
            ) {
                IconButton(onClick = {
                    expanded.value = true
                    result.value = "More icon clicked"

                }) {
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "Localized description"
                    )
                }

                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false }) {
                    DropdownMenuItem(onClick = {
                        expanded.value = false
                        result.value = "First item clicked"

                    }) {
                        Text(text = "First item")
                    }
                }
            }

        }

    )
}

@Preview
@Composable
fun MainScreenAppBarPreview() {
    SimpleNotepadComposeTheme(false) {
        ToDoScreenAppBar()
    }

}