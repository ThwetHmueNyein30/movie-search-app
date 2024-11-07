package com.thn.codingassessment.android.data.repository

import com.thn.codingassessment.android.data.dto.MovieSearchResponse
import com.thn.codingassessment.android.data.remote.MovieSearchApi
import com.thn.codingassessment.android.data.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieSearchRepositoryImpl @Inject constructor(private val movieSearchApi: MovieSearchApi) : MovieSearchRepository {
    override fun searchMovieList(searchKeyword: String): Flow<ApiResponse<MovieSearchResponse>> {
        return movieSearchApi.searchMovies(searchKeyword = searchKeyword)
    }
}