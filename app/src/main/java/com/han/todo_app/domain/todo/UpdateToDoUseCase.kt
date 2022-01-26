package com.han.todo_app.domain.todo

import com.han.todo_app.data.entity.ToDoEntity
import com.han.todo_app.data.repository.ToDoRepository
import com.han.todo_app.domain.UseCase

internal class UpdateToDoUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {
    suspend operator fun invoke(toDoEntity: ToDoEntity){
        return toDoRepository.updateToDoItem(toDoEntity)
    }
}