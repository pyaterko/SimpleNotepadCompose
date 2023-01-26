package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
 fun ShoppingScreenAppBar() {
    TopAppBar(
        title = {
            Text(text = "Shopping")
        }
    )
}

@Preview
@Composable
fun ShoppingAppBarPreview() {
    ShoppingScreenAppBar()
}