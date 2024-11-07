package com.thn.codingassessment.android.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class MovieSearchResponse(
    @Json(name = "Search") val search: List<Movie>? = null,
    @Json(name = "totalResults") val totalResults: String? = null,
    @Json(name = "Response") val response: String? = null
)

@Keep
data class Movie(
    @Json(name = "Title") val title: String? = null,
    @Json(name = "Year") val year: String? = null,
    @Json(name = "imdbID") val imdbID: String? = null,
    @Json(name = "Poster") val poster: String? = null
)
