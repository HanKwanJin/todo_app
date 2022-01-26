package com.han.todo_app.domain.todo

import com.han.todo_app.data.entity.ToDoEntity
import com.han.todo_app.data.repository.ToDoRepository
import com.han.todo_app.domain.UseCase

internal class DeleteToDoItemUseCase(
    private val toDoRepository: ToDoRepository
):UseCase {
    suspend operator fun invoke(itemId: Long){
        return toDoRepository.deleteToDoItem(itemId)
    }
}