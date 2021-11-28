package com.github.ttanaka330.androidsample.api.github

import com.github.ttanaka330.androidsample.api.github.response.SearchRepositoriesResponse
import com.github.ttanaka330.androidsample.api.github.response.SearchUsersResponse
import com.github.ttanaka330.androidsample.model.AppError

class GitHubService(
    private val gitHubApi: GitHubApi
) {

    suspend fun searchUsers(keyword: String): SearchUsersResponse? {
        val response = gitHubApi.searchUsers(query = keyword)
        if (response.isSuccessful) {
            return response.body()
        }
        throw AppError.NetworkException(message = response.errorBody()?.toString())
    }

    suspend fun searchRepositories(keyword: String): SearchRepositoriesResponse? {
        val response = gitHubApi.searchRepositories(query = keyword)
        if (response.isSuccessful) {
            return response.body()
        }
        throw AppError.NetworkException(message = response.errorBody()?.toString())
    }
}
