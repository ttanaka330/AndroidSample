package com.github.ttanaka330.android.sample.repository.impl

import com.github.ttanaka330.android.sample.api.github.GitHubService
import com.github.ttanaka330.android.sample.api.github.entity.RepositoryItem
import com.github.ttanaka330.android.sample.api.github.entity.UserItem
import com.github.ttanaka330.android.sample.model.AppError
import com.github.ttanaka330.android.sample.model.DataStatus
import com.github.ttanaka330.android.sample.model.RepositoryInfo
import com.github.ttanaka330.android.sample.model.UserInfo
import com.github.ttanaka330.android.sample.repository.SearchRepository
import com.github.ttanaka330.android.sample.values.RepositoryId
import com.github.ttanaka330.android.sample.values.RepositoryName
import com.github.ttanaka330.android.sample.values.UserAccount
import com.github.ttanaka330.android.sample.values.UserId
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

internal class SearchRepositoryImpl(
    private val gitHubService: GitHubService,
    private val coroutineDispatcher: CoroutineDispatcher
) : SearchRepository {

    override fun searchUsers(keyword: String): Flow<DataStatus<List<UserInfo>>> =
        flow<DataStatus<List<UserInfo>>> {
            val response = gitHubService.searchUsers(keyword)
            val result = response?.items?.map { it.toUserInfo() } ?: listOf()
            emit(DataStatus.Complete(result))
        }.onStart {
            emit(DataStatus.Starting)
        }.catch {
            val error = if (it is AppError) {
                DataStatus.Error(it)
            } else {
                DataStatus.Error(AppError.UnknownException(it))
            }
            emit(error)
        }.flowOn(coroutineDispatcher)

    override fun searchRepositories(keyword: String): Flow<DataStatus<List<RepositoryInfo>>> =
        flow<DataStatus<List<RepositoryInfo>>> {
            val response = gitHubService.searchRepositories(keyword)
            val result = response?.items?.map { it.toRepositoryInfo() } ?: listOf()
            emit(DataStatus.Complete(result))
        }.onStart {
            emit(DataStatus.Starting)
        }.catch {
            val error = if (it is AppError) {
                DataStatus.Error(it)
            } else {
                DataStatus.Error(AppError.UnknownException(it))
            }
            emit(error)
        }.flowOn(coroutineDispatcher)

    private fun UserItem.toUserInfo(): UserInfo {
        return UserInfo(
            id = UserId(id),
            account = UserAccount(login),
            name = "",
            pageUrl = htmlUrl,
            iconUrl = avatarUrl
        )
    }

    private fun RepositoryItem.toRepositoryInfo(): RepositoryInfo {
        return RepositoryInfo(
            id = RepositoryId(id),
            name = RepositoryName(fullName),
            pageUrl = htmlUrl,
            description = description
        )
    }
}
