package com.github.ttanaka330.androidsample.repository

import com.github.ttanaka330.androidsample.api.github.GitHubModule
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

object RepositoryImplModule {

    fun createModules(): List<Module> = listOf(
        GitHubModule.create(),
        create()
    )

    private fun create(): Module = module {
        single { Dispatchers.IO }
        single<SearchRepository> { SearchRepositoryImpl(get(), get()) }
    }
}
