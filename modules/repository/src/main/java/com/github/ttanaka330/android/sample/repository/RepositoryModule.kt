package com.github.ttanaka330.android.sample.repository

import com.github.ttanaka330.android.sample.api.github.GitHubModule
import com.github.ttanaka330.android.sample.repository.impl.SearchRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

object RepositoryModule {

    fun createModules(): List<Module> = listOf(
        GitHubModule.create(),
        create()
    )

    private fun create(): Module = module {
        single { Dispatchers.IO }
        single<SearchRepository> { SearchRepositoryImpl(get(), get()) }
    }
}
