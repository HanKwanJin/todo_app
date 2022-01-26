package com.han.todo_app.di

import android.content.Context
import androidx.room.Room
import com.han.todo_app.data.local.db.ToDoDatabase
import com.han.todo_app.data.repository.DefaultToDoRepository
import com.han.todo_app.data.repository.ToDoRepository
import com.han.todo_app.domain.todo.*
import com.han.todo_app.domain.todo.DeleteAllToDoItemUseCase
import com.han.todo_app.domain.todo.DeleteToDoItemUseCase
import com.han.todo_app.domain.todo.GetToDoItemUseCase
import com.han.todo_app.domain.todo.GetToDoListUseCase
import com.han.todo_app.domain.todo.InsertToDoListUseCase
import com.han.todo_app.domain.todo.InsertToDoUseCase
import com.han.todo_app.domain.todo.UpdateToDoUseCase
import com.han.todo_app.presentation.detail.DetailMode
import com.han.todo_app.presentation.detail.DetailViewModel
import com.han.todo_app.presentation.list.ListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {
    single { Dispatchers.Main }
    single { Dispatchers.IO }
//viewModel
    viewModel { ListViewModel(get(), get(), get(),get()) }
    viewModel { (detailMode: DetailMode, id: Long) ->
        DetailViewModel(
            detailMode = detailMode,
            id = id,
            get(),
            get(),
            get(),
            get()
        ) }

    //UseCase
    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { UpdateToDoUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }
    factory { DeleteAllToDoItemUseCase(get()) }
    factory { InsertToDoUseCase(get()) }
    factory { DeleteToDoItemUseCase(get()) }

    //Repository
    single<ToDoRepository> { DefaultToDoRepository(get(), get()) }
    single { provideDB(androidApplication()) }
    single { provideToDoDao(get()) }
}
internal fun provideDB(context:Context): ToDoDatabase =
    Room.databaseBuilder(context, ToDoDatabase::class.java,ToDoDatabase.DB_NAME).build()

internal fun provideToDoDao(database: ToDoDatabase) = database.toDoDao()