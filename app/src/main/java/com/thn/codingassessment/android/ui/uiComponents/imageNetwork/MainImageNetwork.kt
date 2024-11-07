package com.thn.codingassessment.android.ui.uiComponents.imageNetwork

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.thn.codingassessment.android.R

@Composable
fun MainNetworkImage(
    modifier: Modifier = Modifier,
    model: ImageRequest,
    contentScale: ContentScale = ContentScale.FillBounds,
    errorPlaceHolder: Int = R.drawable.ic_launcher_foreground,
    loaderSize: Dp = 25.dp,
    imagePadding: Dp = 20.dp,
) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        SubcomposeAsyncImage(
            model = model,
            contentScale = contentScale,
            contentDescription = null,
            modifier = modifier,
            loading = {
                Box(
                    modifier = Modifier,
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(
                        color = Color.LightGray,
                        strokeWidth = 1.5.dp,
                        modifier = Modifier
                            .size(loaderSize)
                    )
                }
            },
            error = {
                Image(
                    painter = painterResource(id = errorPlaceHolder),
                    contentDescription = contentDescription,
                    modifier = modifier.clip(RoundedCornerShape(4.dp)).padding(imagePadding),
                    alignment = Alignment.Center
                )
            }
        )
    }
}