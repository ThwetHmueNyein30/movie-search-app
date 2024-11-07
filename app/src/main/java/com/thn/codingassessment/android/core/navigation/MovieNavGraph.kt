package com.thn.codingassessment.android.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thn.codingassessment.android.ui.screen.movie_search.MovieSearchRoute

internal fun NavGraphBuilder.movieSearchNavGraph() {
    composable<ScreenRoute.MovieSearchScreen>() {
        MovieSearchRoute()
    }
}