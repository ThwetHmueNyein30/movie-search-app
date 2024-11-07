package com.thn.codingassessment.android.ui.uiComponents.imageNetwork

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.thn.codingassessment.android.R
import kotlinx.coroutines.Dispatchers

fun loadImage(
    context: Context,
    imageUrl: String,
    placeHolderAndErrorImage: Int = R.drawable.ic_launcher_foreground,
    size: Int = 500,
): ImageRequest {
    return ImageRequest.Builder(context = context)
        .data(imageUrl)
        .decoderFactory(
            if (SDK_INT >= 28) {
                ImageDecoderDecoder.Factory()
            } else {
                GifDecoder.Factory()
            }
        )
        .setHeader("Cache-Control", "max-age=31536000")
        .size(size)
        .dispatcher(Dispatchers.IO).diskCachePolicy(CachePolicy.ENABLED)
        .memoryCacheKey(imageUrl)
        .diskCacheKey(imageUrl)
        .error(placeHolderAndErrorImage)
        .build()
}
