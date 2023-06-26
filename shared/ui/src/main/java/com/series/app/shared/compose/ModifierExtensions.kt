package com.series.app.shared.compose

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration

fun Modifier.throttledClickable(
    indication: Indication?,
    throttleTimeout: Long = 375L,
    enabled: Boolean = true,
    onThrottledClick: (() -> Unit)?,
): Modifier = composed {
    if (onThrottledClick == null) {
        Modifier
    } else {
        Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = indication,
            enabled = enabled,
            onClick = throttledClick(throttleTimeout, onThrottledClick)
        )
    }
}

fun throttledClick(
    throttleTimeout: Long = 375L,
    onThrottledClick: () -> Unit
): () -> Unit {
    val lock = Any()
    var isClicked = false
    val handler = Handler(Looper.getMainLooper())
    return {
        synchronized(lock) {
            if (!isClicked) {
                onThrottledClick()
                isClicked = true
                handler.postDelayed({
                    isClicked = false
                }, throttleTimeout)
            }
        }
    }
}

@SuppressLint("NewApi")
@Composable
fun isTabletLayout(): Boolean = LocalConfiguration.current.smallestScreenWidthDp >= 600 && LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

