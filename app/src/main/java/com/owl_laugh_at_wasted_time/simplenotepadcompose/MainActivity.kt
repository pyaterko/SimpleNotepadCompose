package com.owl_laugh_at_wasted_time.simplenotepadcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.MainScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen.ShoppingScreenViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.theme.SimpleNotepadComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val shopViewModel: ShoppingScreenViewModel by viewModels()
    private val toDoViewModel: ToDoListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNotepadComposeTheme {
                MainScreen(shopViewModel, toDoViewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleNotepadComposeTheme {

    }
}