package com.github.ttanaka330.android.sample.usecase

import com.github.ttanaka330.android.sample.repository.RepositoryModule
import com.github.ttanaka330.android.sample.usecase.impl.SearchRepositoriesUseCaseImpl
import com.github.ttanaka330.android.sample.usecase.impl.SearchUsersUseCaseImpl
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
