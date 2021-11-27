package com.github.ttanaka330.androidsample.model

sealed class AppError : RuntimeException {
    constructor()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)

    class NetworkException(cause: Throwable?) : AppError(cause)

    class UnknownException(cause: Throwable?) : AppError(cause)
}
