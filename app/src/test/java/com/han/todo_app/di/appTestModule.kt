package com.han.todo_app.di

import com.han.todo_app.data.repository.TestToDoRepository
import com.han.todo_app.data.repository.ToDoRepository
import com.han.todo_app.domain.todo.*
import com.han.todo_app.presentation.detail.DetailMode
import com.han.todo_app.presentation.detail.DetailViewModel
import com.han.todo_app.presentation.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    //viewModel
    viewModel { ListViewModel(get(), get(), get()) }
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
    single<ToDoRepository> { TestToDoRepository() }
}