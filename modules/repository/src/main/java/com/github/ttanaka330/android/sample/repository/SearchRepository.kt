package com.github.ttanaka330.android.sample.repository

import com.github.ttanaka330.android.sample.model.DataStatus
import com.github.ttanaka330.android.sample.model.RepositoryInfo
import com.github.ttanaka330.android.sample.model.UserInfo
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
