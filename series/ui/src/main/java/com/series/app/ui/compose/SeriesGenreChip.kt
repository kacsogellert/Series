package com.series.app.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.series.app.shared.SeriesTheme

@Composable
fun SeriesGenreChip(text: String) {
    Surface(
        shape = CircleShape,
        color = MaterialTheme.colorScheme.onTertiary
    ) {
        Box(modifier = Modifier.padding(SeriesTheme.dimens.padding)) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview
@Composable
private fun SeriesGenreChipPreview() {
    SeriesGenreChip("Drama")
}
