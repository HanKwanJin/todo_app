package com.han.todo_app.data.repository

import com.han.todo_app.data.entity.ToDoEntity

class TestToDoRepository: ToDoRepository {
    private val toDoList: MutableList<ToDoEntity> = mutableListOf()
    override suspend fun getToDoList(): List<ToDoEntity> {
        return toDoList
    }

    override suspend fun insertToDoList(todoList: List<ToDoEntity>) {
        this.toDoList.addAll(todoList)
    }

    override suspend fun insertToDoItem(todoItem: ToDoEntity): Long {
        this.toDoList.add(todoItem)
        return todoItem.id
    }

    override suspend fun updateToDoItem(toDoItem: ToDoEntity): Boolean {
        val foundToDoEntity = toDoList.find { it.id == toDoItem.id  }
        return if(foundToDoEntity == null){
            false
        }else{
            this.toDoList[toDoList.indexOf(foundToDoEntity)] = toDoItem
            true
        }
    }

    override suspend fun getToDoItem(itemId: Long): ToDoEntity? {
        return toDoList.find { it.id == itemId }
    }

    override suspend fun deleteAll() {
        toDoList.clear()
    }

    override suspend fun deleteToDoItem(id: Long): Boolean {
        val foundToDoEntity = toDoList.find { it.id == id  }
        return if (foundToDoEntity == null){
            false
        }else{
            this.toDoList.removeAt(toDoList.indexOf(foundToDoEntity))
            true
        }
    }
}