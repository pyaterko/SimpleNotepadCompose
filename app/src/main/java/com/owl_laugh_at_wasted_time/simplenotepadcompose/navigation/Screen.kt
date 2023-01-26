package com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation

sealed class Screen(
    val route: String
) {
    object ToDo: Screen(TODO_ROUTE)
    object ToDoList: Screen(TODO_LIST_ROUTE)
    object ToDoEdit: Screen(TODO_EDIT_ROUTE)

    object NotesList: Screen(NOTES_LIST_ROUTE)
    object NoteEdit: Screen(NOTE_EDIT_ROUTE)
    object Note : Screen(NOTE_ROUTE)

    object Shop : Screen(SHOP_ROUTE)

    private companion object {
        const val TODO_ROUTE = "ToDoRoute"
        const val TODO_LIST_ROUTE = "ToDoListRoute"
        const val TODO_EDIT_ROUTE = "ToDoEditRoute"

        const val NOTE_ROUTE = "NoteRoute"
        const val NOTES_LIST_ROUTE = "NotesListRoute"
        const val NOTE_EDIT_ROUTE = "NoteEditRoute"

        const val SHOP_ROUTE = "ShopRoute"
    }
}