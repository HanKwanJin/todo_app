package com.han.todo_app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.han.todo_app.data.entity.ToDoEntity
import com.han.todo_app.data.local.db.dao.ToDoDao

@Database(
    entities = [ToDoEntity::class],
    version = 2,
    exportSchema = false
)
abstract class ToDoDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "ToDoDataBase.db"
    }

    abstract fun toDoDao(): ToDoDao

}