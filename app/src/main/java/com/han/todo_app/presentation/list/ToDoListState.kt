package com.han.todo_app.presentation.list

import com.han.todo_app.data.entity.ToDoEntity

sealed class ToDoListState {
    object UnInitialized: ToDoListState()
    object Loading: ToDoListState()

    data class Success(
        val toDoList: List<ToDoEntity>
    ): ToDoListState()

    object Error: ToDoListState()
}