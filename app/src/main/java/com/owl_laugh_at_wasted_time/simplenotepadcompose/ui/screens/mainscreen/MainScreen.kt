package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            MainScreenAppBar()
        },
        bottomBar = {
            MainScreenBottomNavigation()
        }
    ) {

    }
}


@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}