package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import kotlinx.coroutines.launch

@Composable
fun ToDoDisplaySnackBar(
    scaffoldState: ScaffoldState,
    onUndoClicked: () -> Unit,
    toDo: ItemToDo,
    isShow: Boolean,
) {

    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = toDo.key) {
        if (isShow) {
            scope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = setSnackBarMessage(toDo),
                    actionLabel = setActionLabel(toDo)
                )
                undoDeleteNote(snackBarResult, onUndoClicked)
            }
        }

    }
}

private fun setSnackBarMessage(toDo: ItemToDo) = "Delete: ${toDo.title}"
private fun setActionLabel(toDo: ItemToDo) = "UNDO: ${toDo.title}"
private fun undoDeleteNote(
    snackBarResult: SnackbarResult,
    onUndoClicked: () -> Unit,
) {
    if (snackBarResult == SnackbarResult.ActionPerformed) {
        onUndoClicked()
    }
}
