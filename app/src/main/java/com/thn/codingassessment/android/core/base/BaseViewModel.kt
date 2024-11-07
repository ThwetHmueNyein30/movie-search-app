package com.thn.codingassessment.android.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thn.codingassessment.android.ui.resources.StringRes
import com.thn.codingassessment.android.ui.uiComponents.dialog.DialogData
import com.thn.codingassessment.android.util.NotifyEvents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState, UiAction> : ViewModel() {

    // Initial state setup
    abstract fun setInitialState(): UiState

    abstract fun onAction(event: UiAction)

    private val initialState: UiState by lazy { setInitialState() }

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val notifyEvents = Channel<NotifyEvents>(capacity = 10)
    val notifyEventsChannel = notifyEvents.receiveAsFlow()

    fun setState(newState: UiState) {
        _uiState.value = newState
    }

    fun sendEvent(event: NotifyEvents) {
        viewModelScope.launch(Dispatchers.Main) {
            notifyEvents.trySend(event)
        }
    }

    fun handleApiError(
        errorMessage: String
    ) {
        sendEvent(NotifyEvents.ToggleLoading(false))
        sendEvent(
            NotifyEvents.ShowDialog(
                dialogData = DialogData(
                    title = StringRes.ERROR, description = errorMessage
                )
            )
        )
    }

}