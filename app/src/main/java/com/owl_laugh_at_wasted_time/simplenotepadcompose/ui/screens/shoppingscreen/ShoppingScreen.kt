package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.ShoppingScreenAppBar
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.ToDoScreenAppBar
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.theme.SimpleNotepadComposeTheme

@Composable
fun ShoppingScreen() {
    Scaffold(
        modifier = Modifier.padding(bottom = 48.dp),
        topBar = {
            ShoppingScreenAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) {
      Text(text = "Shopping")
    }
}


@Preview
@Composable
private fun ShoppingScreenPreview() {
    SimpleNotepadComposeTheme {
        ShoppingScreen()
    }

}