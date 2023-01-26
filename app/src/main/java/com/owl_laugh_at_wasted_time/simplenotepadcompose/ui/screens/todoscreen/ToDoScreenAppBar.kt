package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
 fun ToDoScreenAppBar() {
    TopAppBar(
        title = {
            Text(text = "ToDo")
        }
    )
}

@Preview
@Composable
fun MainScreenAppBarPreview() {
  ToDoScreenAppBar()
}