package com.thn.codingassessment.android.data.utils

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.EOFException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

sealed class ApiResponse<T> {
    companion object {
        fun <T> create(error: Throwable): ApiResponse<T> {
            return when (error) {
                is SocketTimeoutException, is UnknownHostException, is ConnectException ->
                    ApiErrorResponse(errorMessage = Constants.NETWORK_ERROR)

                is EOFException ->
                    ApiErrorResponse(
                        errorMessage = error.message ?: Constants.SOMETHING_WENT_WRONG
                    )

                else ->
                    ApiErrorResponse(errorMessage = error.message ?: Constants.UNKNOWN_ERROR)
            }
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                ApiSuccessResponse(body = body)
            } else {
                val errorBody = response.errorBody()?.string()
                if (errorBody.isNullOrEmpty()) {
                    ApiErrorResponse(errorMessage = response.message())
                } else {
                    val message = response.errorBody()?.string()
                    if (message.isNullOrEmpty()) {
                        ApiErrorResponse(errorMessage = response.message())
                    } else {
                        val errorMessage = handleErrorResponse(response, message)
                        ApiErrorResponse(errorMessage = errorMessage)

                    }
                }
            }
        }

    }
}


data class ApiSuccessResponse<T>(
    val body: T?,
) : ApiResponse<T>()

data class ApiErrorResponse<T>(
    val errorMessage: String,
) : ApiResponse<T>()


private fun <T> handleErrorResponse(response: Response<T>, errorMessage: String): String {
    return try {
        val errorJson = JSONObject(errorMessage)

        // Customize handling based on the specific error scenario
        when (errorJson.optInt("status", response.code())) {
            404 -> Constants.NOT_FOUND_ERROR
            403 -> Constants.ACCESS_RESTRICTED_ERROR
            400 -> Constants.INVALID_BASE_URL
            else -> Constants.UNKNOWN_ERROR
        }
    } catch (e: JSONException) {
        // Handle JSON parsing exception
        Constants.JSON_PARSER_ERROR
    }
}
