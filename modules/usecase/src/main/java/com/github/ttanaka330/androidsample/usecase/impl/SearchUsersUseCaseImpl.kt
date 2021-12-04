package com.github.ttanaka330.androidsample.usecase.impl

import com.github.ttanaka330.androidsample.model.DataStatus
import com.github.ttanaka330.androidsample.model.UserInfo
import com.github.ttanaka330.androidsample.repository.SearchRepository
import com.github.ttanaka330.androidsample.usecase.SearchUsersUseCase
import kotlinx.coroutines.flow.Flow

internal class SearchUsersUseCaseImpl(
    private val searchRepository: SearchRepository
) : SearchUsersUseCase {

    override fun invoke(keyword: String): Flow<DataStatus<List<UserInfo>>> {
        return searchRepository.searchUsers(keyword)
    }
}
