package com.github.ttanaka330.androidsample.usecase

import com.github.ttanaka330.androidsample.repository.RepositoryModule
import com.github.ttanaka330.androidsample.usecase.impl.SearchRepositoriesUseCaseImpl
import com.github.ttanaka330.androidsample.usecase.impl.SearchUsersUseCaseImpl
import org.koin.core.module.Module
import org.koin.dsl.module

object UseCaseModule {

    fun createModules(): List<Module> =
        RepositoryModule.createModules() + create()

    private fun create(): Module = module {
        single<SearchUsersUseCase> { SearchUsersUseCaseImpl(get()) }
        single<SearchRepositoriesUseCase> { SearchRepositoriesUseCaseImpl(get()) }
    }
}
