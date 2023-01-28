package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit.EditNoteScreenState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.edit.EditNoteViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit.EditViewModelFactory
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit.ToDoEditScreenState
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.edit.ToDoEditViewModel
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list.ToDoListScreenState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditNoteScreen(
    onBackPressed: () -> Unit
) {
    val toDoEditViewModel:EditNoteViewModel= viewModel()
    val screenState =
        toDoEditViewModel.screenState.observeAsState(EditNoteScreenState.Initial)
    val currentState=screenState.value
    if (currentState is EditNoteScreenState.EditNote){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "edit")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { onBackPressed() }
                        ) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    }
                )

            }
        ) {

        }
    }

}