package com.thn.codingassessment.android.core.base

import com.thn.codingassessment.android.data.utils.NetworkResult
import kotlinx.coroutines.flow.Flow


abstract class BaseUseCase<in Params, T> {

    operator fun invoke(params: Params): Flow<NetworkResult<T>> = execute(params)

    protected abstract fun execute(param: Params): Flow<NetworkResult<T>>
}
