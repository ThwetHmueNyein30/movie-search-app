package com.thn.codingassessment.android.ui.uiComponents.dialog

import androidx.annotation.Keep
import androidx.compose.ui.graphics.Color
import com.thn.codingassessment.android.ui.resources.StringRes


@Keep
data class DialogData(
    val title: String,
    val description: String? = null,
    val positiveBtnText: String = StringRes.OK,
    val negativeBtnText: String = StringRes.CANCEL,
    val positiveBtnColor: Color = Color.Blue,
    val negativeBtnColor: Color = Color.Red,
    val dialogType: DialogType = DialogType.NONE
)

@Keep
enum class DialogType {
     NONE
}