package com.series.app.shared

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val smallPadding: Dp,
    val padding: Dp,
    val contentPadding: Dp,
)

val mobileDimension = Dimensions(
    smallPadding = 4.dp,
    padding = 8.dp,
    contentPadding = 16.dp
)

val tabletDimensions = Dimensions(
    smallPadding = 8.dp,
    padding = 16.dp,
    contentPadding = 32.dp
)

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}

val LocalAppDimens = staticCompositionLocalOf { mobileDimension }
