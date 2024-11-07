package com.thn.codingassessment.android.ui.uiComponents.dialog

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import android.view.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.thn.codingassessment.android.ui.resources.CodingAssessmentTheme
import com.thn.codingassessment.android.ui.uiComponents.textView.CommonText


@Composable
fun DialogHost() {
    val dialogEvent by DialogManager.dialogEvents.collectAsState(initial = null)

    dialogEvent?.let { event ->
        when (event) {
            is DialogEvent.ToggleProgress -> event.canShowProgress?.let { AppProgressDialog(it) }

            is DialogEvent.SingleAction -> SingleActionDialog(dialogData = event.dialogData,
                onConfirm = {
                    event.onConfirm()
                    DialogManager.dismissDialog()
                })

            DialogEvent.Dismiss -> DialogManager.dismissDialog()
        }
    }
}

@Composable
fun SingleActionDialog(dialogData: DialogData, onConfirm: () -> Unit) {
    AlertDialog(containerColor = Color.White, onDismissRequest = { }, title = {
        CommonText(
            text = dialogData.title,
            fontWeight = FontWeight(700),
            fontSize = 16.sp,
        )
    }, text = {
        CommonText(
            text = dialogData.description.toString(),
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
        )
    }, confirmButton = {
        Button(
            modifier = Modifier.widthIn(min = 80.dp),
            onClick = onConfirm,
            colors = ButtonDefaults.buttonColors(
                containerColor = CodingAssessmentTheme.surfaceContainerHigh
            )
        ) {
            CommonText(
                text = dialogData.positiveBtnText,
                fontSize = 14.sp,
                color = Color.White
            )
        }
    })
}




@Composable
fun AppProgressDialog(
    showDialog: Boolean,
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = { }, properties = DialogProperties(
                dismissOnBackPress = false, dismissOnClickOutside = false
            )
        ) {
            val curView = LocalView.current
            LaunchedEffect(curView) {
                tailrec fun Context.findWindow(): Window? = when (this) {
                    is Activity -> window
                    is ContextWrapper -> baseContext.findWindow()
                    else -> null
                }

                fun View.findWindow(): Window? =
                    (parent as? DialogWindowProvider)?.window ?: context.findWindow()

                try {
                    val window = curView.findWindow() ?: return@LaunchedEffect
                    val lp = window.attributes
                    lp.dimAmount = 0.3F
                    window.attributes = lp
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }

            Box(
                modifier = Modifier.size(60.dp).clip(RoundedCornerShape(8.dp)).fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(25.dp),
                    color = Color.Gray,
                    strokeWidth = 3.dp,
                    strokeCap = StrokeCap.Round,
                    trackColor = Color.Cyan,
                )
            }
        }
    }
}

