
package com.thn.codingassessment.android.data.utils

sealed interface NetworkResult<out T> {
    data class Success<T>(val data: T?) : NetworkResult<T>
    data class Error(val exception: String? = null) : NetworkResult<Nothing>
    data object Loading : NetworkResult<Nothing>

}



