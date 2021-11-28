package com.github.ttanaka330.androidsample.api.github

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.android.BuildConfig
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit

object GitHubModule {

    private const val URL_GITHUB = "https://api.github.com/"

    fun create(): Module = module {
        single { createOkHttpClient() }
        single { createConverterFactory() }
        single { createRetrofit(get(), get()) }
        single { (get() as Retrofit).create(GitHubApi::class.java) }
        single { GitHubService(get()) }
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().also {
            it.addInterceptor(loggerInterceptor)
        }.build()
    }

    @ExperimentalSerializationApi
    private fun createConverterFactory(): Converter.Factory {
        return Json {
            ignoreUnknownKeys = true
        }.asConverterFactory("application/json".toMediaType())
    }

    private fun createRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_GITHUB)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    private val loggerInterceptor: Interceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) Level.BODY else Level.BASIC
    }
}
