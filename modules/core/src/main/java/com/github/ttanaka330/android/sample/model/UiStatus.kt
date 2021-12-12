package com.github.ttanaka330.android.sample.model

sealed class UiStatus<out R> {
    object Loading : UiStatus<Nothing>()
    data class Success<out T>(val data: T) : UiStatus<T>()
    data class Error(val error: AppError) : UiStatus<Nothing>()
}
