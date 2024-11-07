package com.thn.codingassessment.android.core.provider

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import com.thn.codingassessment.android.core.navigation.ScreenRoute


class NavigationProvider(
    private val navController: NavController,
) {
    fun navigate(route: ScreenRoute) {
        navController.navigate(route)
    }

}

val LocalNavigationManager = staticCompositionLocalOf<NavigationProvider> {
    error("No NavigationManager provided")
}