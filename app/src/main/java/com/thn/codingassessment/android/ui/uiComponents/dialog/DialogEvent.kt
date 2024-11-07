package com.thn.codingassessment.android.ui.uiComponents.dialog


sealed class DialogEvent {

    data class ToggleProgress(
        val canShowProgress: Boolean? = null
    ) : DialogEvent()

    data class SingleAction(
        val dialogData: DialogData,
        val onConfirm: () -> Unit,
    ) : DialogEvent()

    data object Dismiss : DialogEvent()

}
