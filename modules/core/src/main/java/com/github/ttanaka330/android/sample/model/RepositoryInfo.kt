package com.github.ttanaka330.android.sample.model

import com.github.ttanaka330.android.sample.values.RepositoryId
import com.github.ttanaka330.android.sample.values.RepositoryName

/**
 * リポジトリ情報
 *
 * @param id ID
 * @param name リポジトリ名
 * @param pageUrl ページURL
 * @param description 説明
 */
data class RepositoryInfo(
    val id: RepositoryId,
    val name: RepositoryName,
    val pageUrl: String,
    val description: String
)
