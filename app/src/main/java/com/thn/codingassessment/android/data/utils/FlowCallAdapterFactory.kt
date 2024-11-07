package com.thn.codingassessment.android.data.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.awaitResponse
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class FlowCallAdapterFactory private constructor() : CallAdapter.Factory() {
    companion object {
        fun create(): FlowCallAdapterFactory {
            return FlowCallAdapterFactory()
        }
    }

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit,
    ): CallAdapter<*, *>? {
        if (Flow::class.java != getRawType(returnType)) {
            return null
        }
        check(returnType is ParameterizedType) {
            "Flow return type must be parameterized as Flow<ApiResponse<T>> or Flow<T>"
        }
        val responseType = getParameterUpperBound(0, returnType)

        val rawDeferredType = getRawType(responseType)
        return if (rawDeferredType == ApiResponse::class.java) {
            check(responseType is ParameterizedType) {
                "ApiResponse return type must be parameterized as ApiResponse<T>"
            }
            ApiResponseCallAdapter<Any>(getParameterUpperBound(0, responseType))
        } else {
            BodyCallAdapter<Any>(responseType)
        }
    }

    private class BodyCallAdapter<T : Any>(
        private val responseType: Type,
    ) : CallAdapter<T, Flow<T>> {

        override fun responseType() = responseType

        override fun adapt(call: Call<T>): Flow<T> = flow { emit(call.await()) }
    }

    private class ApiResponseCallAdapter<T : Any>(private val responseType: Type) :
        CallAdapter<T, Flow<ApiResponse<T>>> {

        override fun responseType(): Type = responseType

        override fun adapt(call: Call<T>): Flow<ApiResponse<T>> = flow {
            emit(ApiResponse.create(call.awaitResponse()))
        }.catch { exception ->
            emit(ApiResponse.create(exception))
        }
    }

}