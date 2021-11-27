package com.github.ttanaka330.androidsample.usecase

import com.github.ttanaka330.androidsample.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface SearchUsersUseCase {

    /**
     * 検索文字列を含むユーザを取得します。
     *
     * @param keyword 検索文字列
     */
    operator fun invoke(keyword: String): Flow<List<UserInfo>>
}