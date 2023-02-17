package com.example.ganesh.messi_ronaldo.utils

/**
 * Created by Ganesh Padhayay on 13/02/23.
 */
sealed class Response<out T> {
    object Loading : Response<Nothing>()

    data class Success<out T>(
        val data: T?
    ) : Response<T>()

    data class Failure(
        val e: Exception?
    ) : Response<Nothing>()
}