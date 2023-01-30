package com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation

import android.net.Uri
import com.google.gson.Gson
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

sealed class Screen(
    val route: String,
) {
    object ToDo : Screen(TODO_ROUTE)
    object ToDoList : Screen(TODO_LIST_ROUTE)
    object ToDoEdit : Screen(TODO_EDIT_ROUTE) {
        private const val ROUTE_FOR_ARGS = "ToDoEditRoute"
        fun getRouteWithArgs(itemToDo: ItemToDo): String {
            val itemToDoGson=Gson().toJson(itemToDo)
            return "$ROUTE_FOR_ARGS/${itemToDoGson.encode()}"
        }
    }

    object NotesList : Screen(NOTES_LIST_ROUTE)
    object NoteEdit : Screen(NOTE_EDIT_ROUTE) {
        private const val ROUTE_FOR_ARGS = "NoteEditRoute"
        fun getRouteWithArgs(itemNote: ItemNote): String {
            val itemToDoGson=Gson().toJson(itemNote)
            return "$ROUTE_FOR_ARGS/${itemToDoGson.encode()}"
        }
    }

    object Note : Screen(NOTE_ROUTE)

    object Shop : Screen(SHOP_ROUTE)

    companion object {

        const val ITEM_TODO = "itemToDo"
        const val ITEM_NOTE="itemNote"
        const val TODO_ROUTE = "ToDoRoute"
        const val TODO_LIST_ROUTE = "ToDoListRoute"
        const val TODO_EDIT_ROUTE = "ToDoEditRoute/{$ITEM_TODO}"

        const val NOTE_ROUTE = "NoteRoute"
        const val NOTES_LIST_ROUTE = "NotesListRoute"
        const val NOTE_EDIT_ROUTE = "NoteEditRoute/{$ITEM_NOTE}"

        const val SHOP_ROUTE = "ShopRoute"
    }
}

fun String.encode() = Uri.encode(this)
