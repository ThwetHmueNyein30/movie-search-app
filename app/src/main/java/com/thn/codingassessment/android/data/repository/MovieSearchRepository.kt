package com.thn.codingassessment.android.data.repository

import com.thn.codingassessment.android.data.dto.MovieSearchResponse
import com.thn.codingassessment.android.data.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface MovieSearchRepository {
    fun searchMovieList(searchKeyword : String) : Flow<ApiResponse<MovieSearchResponse>>
}