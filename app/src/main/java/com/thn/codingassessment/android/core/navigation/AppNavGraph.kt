package com.thn.codingassessment.android.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.thn.codingassessment.android.core.navigation.anim.screenSlideIn
import com.thn.codingassessment.android.core.navigation.anim.screenSlideOut
import com.thn.codingassessment.android.core.navigation.anim.slideIntoEnterTransition
import com.thn.codingassessment.android.core.navigation.anim.slideOutExitTransition
import com.thn.codingassessment.android.ui.uiComponents.dialog.DialogHost


@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(modifier = Modifier
        .fillMaxSize()
        .navigationBarsPadding(),
        navController = navController,
        startDestination = ScreenRoute.MovieSearchScreen,
        enterTransition = slideIntoEnterTransition,
        exitTransition = slideOutExitTransition,
        popEnterTransition = { screenSlideIn() },
        popExitTransition = { screenSlideOut() }) {

        movieSearchNavGraph()
    }
    DialogHost()

}
