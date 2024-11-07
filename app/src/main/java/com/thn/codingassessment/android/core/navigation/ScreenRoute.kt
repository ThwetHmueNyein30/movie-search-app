package com.thn.codingassessment.android.core.navigation

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
sealed class ScreenRoute {

    @Serializable
    data object MovieSearchScreen : ScreenRoute()

}
