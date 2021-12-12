package com.github.ttanaka330.android.sample.model

sealed class AppError : RuntimeException {
    constructor()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)

    class NetworkException(
        cause: Throwable? = null,
        message: String? = null
    ) : AppError(message, cause)

    class UnknownException(
        cause: Throwable? = null,
        message: String? = null
    ) : AppError(message, cause)
}
