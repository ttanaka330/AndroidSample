package com.github.ttanaka330.android.sample.usecase.impl

import com.github.ttanaka330.android.sample.model.DataStatus
import com.github.ttanaka330.android.sample.model.UserInfo
import com.github.ttanaka330.android.sample.repository.SearchRepository
import com.github.ttanaka330.android.sample.usecase.SearchUsersUseCase
import kotlinx.coroutines.flow.Flow

internal class SearchUsersUseCaseImpl(
    private val searchRepository: SearchRepository
) : SearchUsersUseCase {

    override fun invoke(keyword: String): Flow<DataStatus<List<UserInfo>>> {
        return searchRepository.searchUsers(keyword)
    }
}
