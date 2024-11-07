package com.thn.codingassessment.android.data.remote

import com.thn.codingassessment.android.BuildConfig
import com.thn.codingassessment.android.data.dto.MovieSearchResponse
import com.thn.codingassessment.android.data.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieSearchApi {
    @GET("/")
    fun searchMovies(
        @Query("apikey") apiKey: String = BuildConfig.API_KEY, @Query("s") searchKeyword: String
    ): Flow<ApiResponse<MovieSearchResponse>>

}