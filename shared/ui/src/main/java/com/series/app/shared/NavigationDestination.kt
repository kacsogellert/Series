package com.series.app.shared

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed interface NavigationDestination {
    val route: String

    object Series : NavigationDestination {
        override val route: String = "series"
    }

    object SeriesDetails : NavigationDestination {
        const val SERIES_ID = "seriesId"
        override val route: String = "details"
        val arguments = listOf(navArgument("seriesId") { type = NavType.IntType })
        val routeWithArg: String = "$route/{$SERIES_ID}"
        fun getNavigationRoute(seriesId: Int) = "$route/$seriesId"
    }
}

