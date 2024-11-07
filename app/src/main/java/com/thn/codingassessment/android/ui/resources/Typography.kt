package com.thn.codingassessment.android.ui.resources

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.thn.codingassessment.android.R


val baseline = Typography()

val interFontFamily = FontFamily(
    fonts = listOf(
        Font(R.font.inter_24pt_thin, FontWeight.Thin),               // Weight 100
        Font(R.font.inter_24pt_extralight, FontWeight.ExtraLight),   // Weight 200
        Font(R.font.inter_24pt_light, FontWeight.Light),             // Weight 300
        Font(R.font.inter_24pt_regular, FontWeight.Normal),          // Weight 400
        Font(R.font.inter_24pt_medium, FontWeight.Medium),           // Weight 500
        Font(R.font.inter_24pt_semibold, FontWeight.SemiBold),       // Weight 600
        Font(R.font.inter_24pt_bold, FontWeight.Bold),               // Weight 700
        Font(R.font.inter_24pt_extrabold, FontWeight.ExtraBold),     // Weight 800
        Font(R.font.inter_24pt_black, FontWeight.Black),             // Weight 900
        Font(R.font.inter_24pt_thinitalic, FontWeight.Thin),               // Weight 100 (Italic)
        Font(R.font.inter_24pt_extralightitalic, FontWeight.ExtraLight),   // Weight 200 (Italic)
        Font(R.font.inter_24pt_lightitalic, FontWeight.Light),             // Weight 300 (Italic)
        Font(R.font.inter_24pt_italic, FontWeight.Normal),                 // Weight 400 (Italic)
        Font(R.font.inter_24pt_mediumitalic, FontWeight.Medium),           // Weight 500 (Italic)
        Font(R.font.inter_24pt_semibolditalic, FontWeight.SemiBold),       // Weight 600 (Italic)
        Font(R.font.inter_24pt_bolditalic, FontWeight.Bold),               // Weight 700 (Italic)
        Font(R.font.inter_24pt_extrabolditalic, FontWeight.ExtraBold),     // Weight 800 (Italic)
        Font(R.font.inter_24pt_blackitalic, FontWeight.Black)              // Weight 900 (Italic)
    )
)

// font size
val DISPLAY_LARGE_TEXT_SIZE = 57.sp
val DISPLAY_MEDIUM_TEXT_SIZE = 45.sp
val DISPLAY_SMALL_TEXT_SIZE = 36.sp
val HEADLINE_LARGE_TEXT_SIZE = 32.sp
val HEADLINE_MEDIUM_TEXT_SIZE = 28.sp
val HEADLINE_SMALL_TEXT_SIZE = 24.sp
val TITLE_LARGE_TEXT_SIZE = 22.sp
val REGULAR_MEDIUM16_TEXT_SIZE = 16.sp
val REGULAR_MEDIUM14_TEXT_SIZE = 14.sp
val LABEL_LARGE_TEXT_SIZE = 12.sp
val LABEL_SMALL_TEXT_SIZE = 11.sp


val AppTypographyLight = Typography(
    displayLarge = baseline.displayLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = DISPLAY_LARGE_TEXT_SIZE,
        color = onSecondaryLight
    ),
    displayMedium = baseline.displayMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = DISPLAY_MEDIUM_TEXT_SIZE,
        color = onSecondaryLight
    ),
    displaySmall = baseline.displaySmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = DISPLAY_SMALL_TEXT_SIZE,
        color = onSecondaryLight
    ),
    headlineLarge = baseline.headlineLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = HEADLINE_LARGE_TEXT_SIZE,
        color = onSecondaryLight
    ),
    headlineMedium = baseline.headlineMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = HEADLINE_MEDIUM_TEXT_SIZE,
        color = onSecondaryLight
    ),
    headlineSmall = baseline.headlineSmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = HEADLINE_SMALL_TEXT_SIZE,
        color = onSecondaryLight
    ),
    titleLarge = baseline.titleLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = TITLE_LARGE_TEXT_SIZE,
        color = onSecondaryLight
    ),
    titleMedium = baseline.titleMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = REGULAR_MEDIUM16_TEXT_SIZE,
        color = onSecondaryLight,
    ),
    titleSmall = baseline.titleSmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = REGULAR_MEDIUM14_TEXT_SIZE,
        color = onSecondaryLight
    ),
    bodyLarge = baseline.bodyLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = REGULAR_MEDIUM16_TEXT_SIZE,
        color = onSecondaryLight
    ),
    bodyMedium = baseline.bodyMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = REGULAR_MEDIUM14_TEXT_SIZE,
        color = onSecondaryLight
    ),
    bodySmall = baseline.bodySmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = LABEL_LARGE_TEXT_SIZE,
        color = onSecondaryLight
    ),
    labelLarge = baseline.labelLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = REGULAR_MEDIUM14_TEXT_SIZE,
        color = onSecondaryLight
    ),
    labelMedium = baseline.labelMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = LABEL_LARGE_TEXT_SIZE,
        color = onSecondaryLight
    ),
    labelSmall = baseline.labelSmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = LABEL_SMALL_TEXT_SIZE,
        color = onSecondaryLight
    ),
)

val AppTypographyDark = Typography(
    displayLarge = baseline.displayLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = DISPLAY_LARGE_TEXT_SIZE,
        color = onSecondaryDark
    ),
    displayMedium = baseline.displayMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = DISPLAY_MEDIUM_TEXT_SIZE,
        color = onSecondaryDark
    ),
    displaySmall = baseline.displaySmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = DISPLAY_SMALL_TEXT_SIZE,
        color = onSecondaryDark
    ),
    headlineLarge = baseline.headlineLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = HEADLINE_LARGE_TEXT_SIZE,
        color = onSecondaryDark
    ),
    headlineMedium = baseline.headlineMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = HEADLINE_MEDIUM_TEXT_SIZE,
        color = onSecondaryDark
    ),
    headlineSmall = baseline.headlineSmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = HEADLINE_SMALL_TEXT_SIZE,
        color = onSecondaryDark
    ),
    titleLarge = baseline.titleLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = TITLE_LARGE_TEXT_SIZE,
        color = secondaryDark
    ),
    titleMedium = baseline.titleMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = REGULAR_MEDIUM16_TEXT_SIZE,
        color = secondaryDark,
    ),
    titleSmall = baseline.titleSmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = REGULAR_MEDIUM14_TEXT_SIZE,
        color = secondaryDark
    ),
    bodyLarge = baseline.bodyLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = REGULAR_MEDIUM16_TEXT_SIZE,
        color = secondaryDark
    ),
    bodyMedium = baseline.bodyMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = REGULAR_MEDIUM14_TEXT_SIZE,
        color = secondaryDark
    ),
    bodySmall = baseline.bodySmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = LABEL_LARGE_TEXT_SIZE,
        color = secondaryDark
    ),
    labelLarge = baseline.labelLarge.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = REGULAR_MEDIUM14_TEXT_SIZE,
        color = secondaryDark
    ),
    labelMedium = baseline.labelMedium.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = LABEL_LARGE_TEXT_SIZE,
        color = secondaryDark
    ),
    labelSmall = baseline.labelSmall.copy(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = LABEL_SMALL_TEXT_SIZE,
        color = secondaryDark
    ),
)