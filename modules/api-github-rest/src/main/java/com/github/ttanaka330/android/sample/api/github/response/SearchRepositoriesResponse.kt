package com.github.ttanaka330.android.sample.api.github.response

import com.github.ttanaka330.android.sample.api.github.entity.RepositoryItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * リポジトリ検索レスポンス
 *
 * @param totalCount 総件数
 * @param incompleteResults 不完全な結果 (制限時間を超えるクエリの場合 true)
 * @param items ユーザー情報
 * @see <a href="https://docs.github.com/ja/rest/reference/search#search-repositories">Github API</a>
 */
@Serializable
data class SearchRepositoriesResponse(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("incomplete_results")
    val incompleteResults: Boolean,
    @SerialName("items")
    val items: List<RepositoryItem>
)
