package com.thn.codingassessment.android.core.navigation.anim

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry


fun AnimatedContentTransitionScope<NavBackStackEntry>.screenSlideIn(): EnterTransition =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(700)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.screenSlideOut(): ExitTransition =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(700)
    )


