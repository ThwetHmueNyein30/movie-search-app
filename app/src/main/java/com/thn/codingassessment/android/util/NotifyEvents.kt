package com.thn.codingassessment.android.util

import com.thn.codingassessment.android.ui.uiComponents.dialog.DialogData


sealed interface NotifyEvents {
    data class ToggleLoading(val isLoading: Boolean) : NotifyEvents
    data class ShowDialog(
        val dialogData: DialogData,
    ) : NotifyEvents
}
