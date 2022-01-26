package com.han.todo_app.domain.todo

import com.han.todo_app.data.entity.ToDoEntity
import com.han.todo_app.data.repository.ToDoRepository
import com.han.todo_app.domain.UseCase

internal class InsertToDoUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {
    suspend operator fun invoke(toDoItem: ToDoEntity) : Long{
        return toDoRepository.insertToDoItem(toDoItem)
    }
}