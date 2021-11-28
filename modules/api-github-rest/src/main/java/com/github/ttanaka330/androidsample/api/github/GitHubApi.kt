package com.github.ttanaka330.androidsample.api.github

import com.github.ttanaka330.androidsample.api.github.response.SearchRepositoriesResponse
import com.github.ttanaka330.androidsample.api.github.response.SearchUsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @see <a href="https://docs.github.com/ja/rest">GitHub Docs: REST API</a>
 */
interface GitHubApi {

    /**
     * ユーザー検索
     *
     * @param query 検索クエリ
     * @param page ページ (default:1)
     * @param perPage ページサイズ (default:30, max:100)
     * @param sort ソート順 (default:"desc")
     * @param order 並び順
     */
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int? = null,
        @Query("per_page") perPage: Int? = null,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null
    ) : Response<SearchUsersResponse>

    /**
     * リポジトリ検索
     *
     * @param query 検索クエリ
     * @param page ページ
     * @param perPage ページサイズ (default:30)
     * @param sort ソート順
     * @param order 並び順
     */
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("page") page: Int? = null,
        @Query("per_page") perPage: Int? = null,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null
    ): Response<SearchRepositoriesResponse>
}
