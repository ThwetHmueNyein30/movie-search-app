package com.thn.codingassessment.android.core.provider

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation.NavController


@Composable
fun LocalProviderWrapper(
    activity: ComponentActivity,
    navController: NavController,
    content: @Composable () -> Unit
) {
    val mKeyboardManager = remember(activity) {
        KeyboardManager(activity)
    }

    val mNavigationManager = remember(navController) {
        NavigationProvider(navController)
    }

    CompositionLocalProvider(
        LocalKeyBoardManager provides mKeyboardManager,
        LocalNavigationManager provides mNavigationManager,

    ) {
        content()
    }
}