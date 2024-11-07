package com.thn.codingassessment.android.ui.screen.movie_search

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thn.codingassessment.android.core.base.BaseScreen
import com.thn.codingassessment.android.data.dto.Movie

@Composable()
fun MovieSearchRoute() {
    val viewModel: MovieSearchViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    BaseScreen(notifyEventsChannel = viewModel.notifyEventsChannel, content = {
        MovieSearchScreen(
            uiState = uiState, onAction = viewModel::onAction
        )
    })

}

data class MovieUiState(
    val movie: List<Movie> = emptyList()
)

sealed interface MovieUiAction {
    data class SearchMovie(val searchKeyword: String) : MovieUiAction
    data object ClearMovieList : MovieUiAction
}