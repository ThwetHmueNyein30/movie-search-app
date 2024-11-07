package com.thn.codingassessment.android.core.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.thn.codingassessment.android.ui.uiComponents.dialog.DialogData
import com.thn.codingassessment.android.ui.uiComponents.dialog.DialogManager
import com.thn.codingassessment.android.ui.uiComponents.dialog.OnDialogEvents
import com.thn.codingassessment.android.util.CollectEventsFromVM
import com.thn.codingassessment.android.util.NotifyEvents
import kotlinx.coroutines.flow.Flow


@Composable
internal fun BaseScreen(
    modifier: Modifier = Modifier,
    notifyEventsChannel: Flow<NotifyEvents>,
    dialogEvents: (OnDialogEvents) -> Unit = {},
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        content = {
            CollectEventsFromVM(flow = notifyEventsChannel) { event ->
                when (event) {
                    is NotifyEvents.ToggleLoading -> DialogManager.toggleProgress(event.isLoading)
                    is NotifyEvents.ShowDialog -> {
                        DialogManager.showSingleActionDialog(DialogData(
                            title = event.dialogData.title,
                            description = event.dialogData.description,
                        ), onConfirm = {
                            dialogEvents.invoke(OnDialogEvents.POSITIVE_CLICK)
                        })
                    }
                }
            }
            content()
        },
    )
}
