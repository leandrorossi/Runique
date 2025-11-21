package com.leandrour.analytics.analytics_feature

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.play.core.splitcompat.SplitCompat
import com.leandrour.analytics.data.di.analyticsModule
import com.leandrour.analytics.presentation.AnalyticsDashboardScreenRoot
import com.leandrour.analytics.presentation.di.analyticsPresentationModule
import com.leandrour.core.presentation.designsystem.RuniqueTheme
import org.koin.core.context.loadKoinModules

class AnalyticsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        loadKoinModules(
            listOf(
                analyticsModule,
                analyticsPresentationModule
            )
        )
        SplitCompat.installActivity(this)

        setContent {
            RuniqueTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "analytics_dashboard"
                ) {
                    composable(route = "analytics_dashboard") {
                        AnalyticsDashboardScreenRoot(
                            onBackClick = { finish() }
                        )
                    }
                }
            }

        }
    }
}