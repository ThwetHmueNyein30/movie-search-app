package com.thn.codingassessment.android.ui.uiComponents.textView

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.thn.codingassessment.android.ui.resources.CodingAssessmentTheme
import com.thn.codingassessment.android.ui.resources.CodingAssessmentThemeTypography


@Composable
fun CommonText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CodingAssessmentTheme.secondary,
    fontSize: TextUnit =14.sp,
    fontWeight: FontWeight = FontWeight.W500,
    lineHeight: TextUnit = 16.sp,
    maxLines: Int = 2,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier,
        text = text,
        maxLines = maxLines,
        textAlign = textAlign,
        style = CodingAssessmentThemeTypography.bodyLarge.copy(
            fontWeight = fontWeight, fontSize = fontSize, lineHeight = lineHeight, color = color
        ),
        textDecoration = textDecoration,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview
@Composable
fun CustomTextPreview() {
}