package com.thn.codingassessment.android.ui.uiComponents.no_data

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thn.codingassessment.android.ui.resources.AppIcons
import com.thn.codingassessment.android.ui.resources.StringRes
import com.thn.codingassessment.android.ui.uiComponents.textView.CommonText


@Composable
fun NoDataComponent(
    @DrawableRes image: Int = AppIcons.icNoData,
    size: Dp = 130.dp,
    labelText: String = StringRes.NO_DATA
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.size(size),
        )
        CommonText(
            text = labelText,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
    }

}