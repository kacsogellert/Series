package com.series.app.series.shared


sealed class ResultWrapper<out T> {
    data class Success<out T>(val data: T) : ResultWrapper<T>()

    data class Exception<out T>(val exception: Throwable) : ResultWrapper<T>()

    fun isSuccess(): Boolean = this is Success<*>

    fun isFailure(): Boolean = !isSuccess()
}

suspend inline fun <T> wrapToResult(crossinline func: suspend () -> T): ResultWrapper<T> {
    return try {
        ResultWrapper.Success(func())
    } catch (unhandledException: Throwable) {
        ResultWrapper.Exception(unhandledException)
    }
}
