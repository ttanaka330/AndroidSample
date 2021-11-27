package com.github.ttanaka330.androidsample.usecase

import com.github.ttanaka330.androidsample.model.RepositoryInfo
import kotlinx.coroutines.flow.Flow

interface SearchRepositoriesUseCase {

    /**
     * 検索文字列を含むリポジトリを取得します。
     *
     * @param keyword 検索文字列
     */
    operator fun invoke(keyword: String): Flow<List<RepositoryInfo>>
}
