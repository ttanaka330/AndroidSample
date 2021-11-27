package com.github.ttanaka330.androidsample.model

sealed class DataStatus<out R> {
    object Starting : DataStatus<Nothing>()
    data class Complete<out T>(val data: T) : DataStatus<T>()
    data class Error(val error: AppError) : DataStatus<Nothing>()
}
