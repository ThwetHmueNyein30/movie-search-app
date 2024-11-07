package com.thn.codingassessment.android.ui.uiComponents

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.thn.codingassessment.android.ui.resources.CodingAssessmentTheme
import com.thn.codingassessment.android.ui.uiComponents.textView.CommonText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopToolBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = CodingAssessmentTheme.surfaceContainerHigh),
        title = { CommonText(text = "Movies", color = Color.White, fontSize = 16.sp) },
    )
}