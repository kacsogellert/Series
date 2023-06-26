package com.series.app.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.series.app.shared.SeriesTheme
import com.series.app.shared.compose.throttledClickable

@Composable
fun SeriesBackIcon(onClick: () -> Unit) {
    Surface(
        shape = CircleShape,
        modifier = Modifier
            .padding(SeriesTheme.dimens.contentPadding),
        border = BorderStroke(Dp.Hairline, MaterialTheme.colorScheme.outlineVariant),
        color = MaterialTheme.colorScheme.inversePrimary,
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .throttledClickable(
                    indication = rememberRipple(bounded = true),
                    onThrottledClick = onClick
                )
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                imageVector = Icons.Sharp.ArrowBack,
                tint = Color.White,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun SeriesBackIconPreview() {
    SeriesBackIcon(onClick = {})
}
