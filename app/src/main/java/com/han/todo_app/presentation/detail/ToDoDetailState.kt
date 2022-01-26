package com.han.todo_app.presentation.detail

import com.han.todo_app.data.entity.ToDoEntity

sealed class ToDoDetailState{
    object UnInitialized: ToDoDetailState()
    object Loading: ToDoDetailState()

    data class Success(
        val toDoItem: ToDoEntity
    ): ToDoDetailState()

    object Delete: ToDoDetailState()
    object Modify: ToDoDetailState()
    object Error: ToDoDetailState()
    object Write: ToDoDetailState()
}
