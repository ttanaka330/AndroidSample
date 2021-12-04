package com.github.ttanaka330.androidsample.repository

import com.github.ttanaka330.androidsample.model.DataStatus
import com.github.ttanaka330.androidsample.model.RepositoryInfo
import com.github.ttanaka330.androidsample.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    /**
     * 検索文字列を含むユーザを取得します。
     *
     * @param keyword 検索文字列
     */
    fun searchUsers(keyword: String): Flow<DataStatus<List<UserInfo>>>

    /**
     * 検索文字列を含むリポジトリを取得します。
     *
     * @param keyword 検索文字列
     */
    fun searchRepositories(keyword: String): Flow<DataStatus<List<RepositoryInfo>>>
}
