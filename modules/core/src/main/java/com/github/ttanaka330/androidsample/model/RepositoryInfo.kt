package com.github.ttanaka330.androidsample.model

import com.github.ttanaka330.androidsample.values.RepositoryId
import com.github.ttanaka330.androidsample.values.RepositoryName

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
