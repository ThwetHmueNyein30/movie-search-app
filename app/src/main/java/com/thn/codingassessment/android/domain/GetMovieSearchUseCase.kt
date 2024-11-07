package com.thn.codingassessment.android.domain

import com.thn.codingassessment.android.data.dto.MovieSearchResponse
import com.thn.codingassessment.android.data.repository.MovieSearchRepository
import com.thn.codingassessment.android.data.utils.ApiErrorResponse
import com.thn.codingassessment.android.data.utils.ApiSuccessResponse
import com.thn.codingassessment.android.core.base.BaseUseCase
import com.thn.codingassessment.android.data.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

open class GetMovieSearchUseCase @Inject constructor(private val repository: MovieSearchRepository) :
    BaseUseCase<String, MovieSearchResponse>() {
    override fun execute(param: String): Flow<NetworkResult<MovieSearchResponse>> = flow {
        emit(NetworkResult.Loading)
        repository.searchMovieList(param).collect { response ->
            when (response) {
                is ApiSuccessResponse -> {
                    emit(NetworkResult.Success(response.body))
                }
                is ApiErrorResponse -> emit(NetworkResult.Error(exception = response.errorMessage))

            }
        }

    }
}