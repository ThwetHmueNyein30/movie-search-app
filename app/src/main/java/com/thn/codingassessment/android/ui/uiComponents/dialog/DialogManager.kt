package com.thn.codingassessment.android.ui.uiComponents.dialog

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object DialogManager {
    private val _dialogEvents = MutableSharedFlow<DialogEvent>(extraBufferCapacity = 10)
    val dialogEvents: SharedFlow<DialogEvent> = _dialogEvents.asSharedFlow()

    fun toggleProgress(canShowLoading: Boolean) {
        _dialogEvents.tryEmit(DialogEvent.ToggleProgress(canShowLoading))
    }

    fun showSingleActionDialog(dialogData: DialogData, onConfirm: () -> Unit) {
        _dialogEvents.tryEmit(DialogEvent.SingleAction(dialogData, onConfirm))
    }


    fun dismissDialog() {
        _dialogEvents.tryEmit(DialogEvent.Dismiss)
    }

}
