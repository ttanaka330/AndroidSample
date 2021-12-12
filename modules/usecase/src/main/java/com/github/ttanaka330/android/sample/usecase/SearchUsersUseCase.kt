package com.github.ttanaka330.android.sample.usecase

import com.github.ttanaka330.android.sample.model.DataStatus
import com.github.ttanaka330.android.sample.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface SearchUsersUseCase {

    /**
     * 検索文字列を含むユーザを取得します。
     *
     * @param keyword 検索文字列
     */
    operator fun invoke(keyword: String): Flow<DataStatus<List<UserInfo>>>
}
