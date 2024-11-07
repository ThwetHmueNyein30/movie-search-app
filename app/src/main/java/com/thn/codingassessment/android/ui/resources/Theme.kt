package com.thn.codingassessment.android.ui.resources

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

val CodingAssessmentTheme: ColorScheme
    @Composable get() = MaterialTheme.colorScheme

val CodingAssessmentThemeTypography: Typography
    @Composable get() = MaterialTheme.typography

@Composable
fun CodingAssessmentTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = if (darkTheme) AppTypographyDark else AppTypographyLight,
        content = content
    )
}