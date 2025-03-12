package com.app.xpertgroup.domain.utils

import com.google.gson.Gson
import retrofit2.Call

fun <T, R> request(
    call: Call<T>,
    transform: (T) -> R,
    default: T
): Result<R> {
    return try {
        val response = call.execute()
        if (response.isSuccessful) {
            // If the call is successful, transform the response and return it as a success result
            Result.success(transform(response.body() ?: default))
        } else {
            // If the response is not successful, return an error result
            val gson = Gson()
            val errorBody = response.errorBody()?.string() ?: response.message()
            val errorResponse = gson.fromJson(errorBody, ErrorResponse::class.java)
            Result.failure(Throwable(errorResponse.message))
        }
    } catch (exception: Throwable) {
        // If an exception occurs during the network call or processing, return an error result
        Result.failure(exception)
    }
}

data class ErrorResponse(
    val timestamp: String,
    val path: String,
    val status: Int,
    val message: String,
    val requestId: String
)