package com.thn.codingassessment.android.ui.screen.movie_search


import androidx.lifecycle.viewModelScope
import com.thn.codingassessment.android.domain.GetMovieSearchUseCase
import com.thn.codingassessment.android.core.base.BaseViewModel
import com.thn.codingassessment.android.ui.resources.StringRes
import com.thn.codingassessment.android.util.NotifyEvents
import com.thn.codingassessment.android.data.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getMovieSearchUseCase: GetMovieSearchUseCase,
) : BaseViewModel<MovieUiState, MovieUiAction>() {
    override fun setInitialState(): MovieUiState = MovieUiState()

    override fun onAction(event: MovieUiAction) {
        when (event) {
            is MovieUiAction.SearchMovie -> searchMovie(event.searchKeyword)
            MovieUiAction.ClearMovieList -> setState(uiState.value.copy(movie = emptyList()))
        }
    }

    private fun searchMovie(searchKeyword: String) {
        getMovieSearchUseCase.invoke(searchKeyword).flowOn(Dispatchers.IO)
            .onEach { result ->
                when (result) {
                    NetworkResult.Loading -> sendEvent(NotifyEvents.ToggleLoading(true))
                    is NetworkResult.Success -> {
                        sendEvent(NotifyEvents.ToggleLoading(false))
                        setState(
                            uiState.value.copy(
                                movie = result.data?.search ?: emptyList()
                            )
                        )
                    }
                    is NetworkResult.Error -> handleApiError(
                        result.exception ?: StringRes.DEFAULT_ERROR_MESSAGE
                    )

                }
            }.launchIn(viewModelScope)
    }

}