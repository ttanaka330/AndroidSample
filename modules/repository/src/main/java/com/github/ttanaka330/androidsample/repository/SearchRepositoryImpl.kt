package com.github.ttanaka330.androidsample.repository

import com.github.ttanaka330.androidsample.api.github.GitHubService
import com.github.ttanaka330.androidsample.api.github.entity.RepositoryItem
import com.github.ttanaka330.androidsample.api.github.entity.UserItem
import com.github.ttanaka330.androidsample.model.AppError
import com.github.ttanaka330.androidsample.model.DataStatus
import com.github.ttanaka330.androidsample.model.RepositoryInfo
import com.github.ttanaka330.androidsample.model.UserInfo
import com.github.ttanaka330.androidsample.values.RepositoryId
import com.github.ttanaka330.androidsample.values.RepositoryName
import com.github.ttanaka330.androidsample.values.UserAccount
import com.github.ttanaka330.androidsample.values.UserId
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

internal class SearchRepositoryImpl(
    private val gitHubService: GitHubService,
    private val coroutineDispatcher: CoroutineDispatcher
) : SearchRepository {

    override fun searchUsers(keyword: String): Flow<List<UserInfo>> = flow {
        val response = gitHubService.searchUsers(keyword)
        val result = response?.items?.map { it.toUserInfo() } ?: listOf()
        emit(result)
    }.onStart {
        DataStatus.Starting
    }.catch {
        if (it is AppError) {
            DataStatus.Error(it)
        } else {
            DataStatus.Error(AppError.UnknownException(it))
        }
    }.onCompletion {
        DataStatus.Complete(it)
    }.flowOn(coroutineDispatcher)

    override fun searchRepositories(keyword: String): Flow<List<RepositoryInfo>> = flow {
        val response = gitHubService.searchRepositories(keyword)
        val result = response?.items?.map { it.toRepositoryInfo() } ?: listOf()
        emit(result)
    }.onStart {
        DataStatus.Starting
    }.catch {
        if (it is AppError) {
            DataStatus.Error(it)
        } else {
            DataStatus.Error(AppError.UnknownException(it))
        }
    }.onCompletion {
        DataStatus.Complete(it)
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
