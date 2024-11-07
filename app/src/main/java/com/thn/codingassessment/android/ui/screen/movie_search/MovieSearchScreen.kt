package com.thn.codingassessment.android.ui.screen.movie_search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.thn.codingassessment.android.ui.screen.movie_search.component.MovieItem
import com.thn.codingassessment.android.ui.screen.movie_search.component.SearchBar
import com.thn.codingassessment.android.ui.uiComponents.TopToolBar
import com.thn.codingassessment.android.ui.uiComponents.no_data.NoDataComponent
import com.thn.codingassessment.android.util.noRippleClickable

@Composable
fun MovieSearchScreen(uiState: MovieUiState, onAction: (MovieUiAction) -> Unit) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopToolBar()
        Column(
            modifier = Modifier
                .padding(8.dp)
                .noRippleClickable { focusManager.clearFocus() }) {
            SearchBar(onSearch = { query -> onAction.invoke(MovieUiAction.SearchMovie(query)) },
                onClear = {
                    onAction.invoke(MovieUiAction.ClearMovieList)
                })
            if (uiState.movie.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center
                ) {
                    NoDataComponent()
                }
            } else {
                LazyColumn {
                    items(uiState.movie.size) { movie ->
                        MovieItem(uiState.movie[movie])
                    }
                }
            }

        }

    }

}