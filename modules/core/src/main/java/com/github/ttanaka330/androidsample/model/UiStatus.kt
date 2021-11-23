package com.github.ttanaka330.androidsample.model

sealed class UiStatus<out R> {
    object Loading : UiStatus<Nothing>()
    data class Success<out T>(val data: T) : UiStatus<T>()
    data class Error(val throwable: Throwable) : UiStatus<Nothing>()
}
