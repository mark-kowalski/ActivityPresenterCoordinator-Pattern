package dev.mko.dry.http

sealed class HttpResponse<T> {
    data class Success<T>(val data: T) : HttpResponse<T>()
    data class Failure<T>(val error: Throwable) : HttpResponse<T>()
}