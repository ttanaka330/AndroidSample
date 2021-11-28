package com.github.ttanaka330.androidsample.api.github.response

import com.github.ttanaka330.androidsample.api.github.entity.UserItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ユーザー検索レスポンス
 *
 * @param totalCount 総件数
 * @param incompleteResults 不完全な結果 (制限時間を超えるクエリの場合 true)
 * @param items ユーザー情報
 * @see <a href="https://docs.github.com/en/rest/reference/search#search-users">Github API</a>
 */
@Serializable
data class SearchUsersResponse(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("incomplete_results")
    val incompleteResults: Boolean,
    @SerialName("items")
    val items: List<UserItem>
)
