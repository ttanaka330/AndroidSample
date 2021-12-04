package com.github.ttanaka330.androidsample.usecase.impl

import com.github.ttanaka330.androidsample.model.DataStatus
import com.github.ttanaka330.androidsample.model.RepositoryInfo
import com.github.ttanaka330.androidsample.repository.SearchRepository
import com.github.ttanaka330.androidsample.usecase.SearchRepositoriesUseCase
import kotlinx.coroutines.flow.Flow

internal class SearchRepositoriesUseCaseImpl(
    private val searchRepository: SearchRepository
) : SearchRepositoriesUseCase {

    override fun invoke(keyword: String): Flow<DataStatus<List<RepositoryInfo>>> {
        return searchRepository.searchRepositories(keyword)
    }
}
