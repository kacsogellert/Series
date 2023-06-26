package com.series.app

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.series.app.shared.NavigationDestination
import com.series.app.ui.SeriesScreen
import com.series.app.ui.detail.SeriesDetailsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier
            .statusBarsPadding()
            .systemBarsPadding(),
        navController = navController,
        startDestination = NavigationDestination.Series.route
    ) {
        composable(NavigationDestination.Series.route) {
            SeriesScreen(onNavigateToDetails = { navController.navigate(NavigationDestination.SeriesDetails.getNavigationRoute(it)) })
        }
        composable(
            route = NavigationDestination.SeriesDetails.routeWithArg,
            arguments = NavigationDestination.SeriesDetails.arguments
        ) {
            SeriesDetailsScreen(onUpClick = {
                navController.navigateUp()
            })
        }
    }
}
