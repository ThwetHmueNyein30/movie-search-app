package com.thn.codingassessment.android.ui.screen.movie_search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thn.codingassessment.android.data.dto.Movie
import com.thn.codingassessment.android.ui.resources.CodingAssessmentTheme
import com.thn.codingassessment.android.ui.uiComponents.imageNetwork.MainNetworkImage
import com.thn.codingassessment.android.ui.uiComponents.imageNetwork.loadImage
import com.thn.codingassessment.android.ui.uiComponents.textView.CommonText
import com.thn.codingassessment.android.util.formatYear

@Composable
fun MovieItem(movie:Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    CodingAssessmentTheme.surfaceContainerHigh
                )
        ) {
            MainNetworkImage(
                model = loadImage(
                    context = LocalContext.current,
                    imageUrl = movie.poster ?: ""
                ),
                modifier = Modifier.fillMaxSize(),
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            CommonText(text = movie.title ?: "", fontWeight = FontWeight.Bold, maxLines = 1,)
            CommonText(text = (movie.year ?: "").formatYear(), color = Color.Gray, fontSize = 14.sp)
        }
    }
}
