package com.thn.codingassessment.android.core.navigation.anim

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry



val slideIntoEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition =
    {
        slideIntoContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(700)
        )
    }

val slideOutExitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition =
    {
        slideOutOfContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(700)
        )
    }

