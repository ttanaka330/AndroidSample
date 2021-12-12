package com.github.ttanaka330.android.sample.usecase.impl

import com.github.ttanaka330.android.sample.model.DataStatus
import com.github.ttanaka330.android.sample.model.RepositoryInfo
import com.github.ttanaka330.android.sample.repository.SearchRepository
import com.github.ttanaka330.android.sample.usecase.SearchRepositoriesUseCase
import kotlinx.coroutines.flow.Flow

internal class SearchRepositoriesUseCaseImpl(
    private val searchRepository: SearchRepository
) : SearchRepositoriesUseCase {

    override fun invoke(keyword: String): Flow<DataStatus<List<RepositoryInfo>>> {
        return searchRepository.searchRepositories(keyword)
    }
}
