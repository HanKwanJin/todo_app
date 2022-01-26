package com.han.todo_app.data.repository

import com.han.todo_app.data.entity.ToDoEntity

/**
 * 1. insertToDoList
 * 2. getToDoList
 * 3. updateToDoItem
 */
interface ToDoRepository {
    suspend fun getToDoList(): List<ToDoEntity>
    suspend fun insertToDoList(todoList: List<ToDoEntity>)
    suspend fun insertToDoItem(todoItem: ToDoEntity) : Long
    suspend fun updateToDoItem(toDoItem: ToDoEntity)
    suspend fun getToDoItem(itemId: Long): ToDoEntity?
    suspend fun deleteAll()
    suspend fun deleteToDoItem(id: Long)
}