package com.thn.codingassessment.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.rememberNavController
import com.thn.codingassessment.android.core.navigation.AppNavGraph
import com.thn.codingassessment.android.core.provider.LocalProviderWrapper
import com.thn.codingassessment.android.ui.resources.CodingAssessmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false
        setContent {
            val navController = rememberNavController()
            LocalProviderWrapper(activity = this, navController = navController, content = {
                CodingAssessmentTheme {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(CodingAssessmentTheme.surface)
                    ) {
                        AppNavGraph(navController)
                    }
                }
            })
        }
    }
}
