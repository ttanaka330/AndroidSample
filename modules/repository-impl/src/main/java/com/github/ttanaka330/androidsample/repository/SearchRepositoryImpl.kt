package com.github.ttanaka330.androidsample.repository

import com.github.ttanaka330.androidsample.api.github.GitHubApi
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

class SearchRepositoryImpl(
    private val gitHubApi: GitHubApi,
    private val coroutineDispatcher: CoroutineDispatcher
) : SearchRepository {

    override fun searchUsers(keyword: String): Flow<List<UserInfo>> = flow {
        val response = gitHubApi.searchUsers(query = keyword)
        if (response.isSuccessful) {
            val result = response.body()?.items?.map { it.toUserInfo() } ?: listOf()
            emit(result)
        }
        throw RuntimeException(message = response.errorBody()?.toString())
    }.onStart {
        DataStatus.Starting
    }.catch {
        val e = AppError.NetworkException(it)
        DataStatus.Error(e)
    }.onCompletion {
        DataStatus.Complete(it)
    }.flowOn(coroutineDispatcher)

    override fun searchRepositories(keyword: String): Flow<List<RepositoryInfo>> = flow {
        val response = gitHubApi.searchRepositories(query = keyword)
        if (response.isSuccessful) {
            val result = response.body()?.items?.map { it.toRepositoryInfo() } ?: listOf()
            emit(result)
        }
        throw RuntimeException(message = response.errorBody()?.toString())
    }.onStart {
        DataStatus.Starting
    }.catch {
        val e = AppError.NetworkException(it)
        DataStatus.Error(e)
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
