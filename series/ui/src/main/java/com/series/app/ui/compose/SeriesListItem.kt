package com.series.app.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.series.app.series.shared.model.SeriesModel
import com.series.app.series.shared.model.mock.MockSeriesModel
import com.series.app.series.ui.R
import com.series.app.shared.SeriesTheme
import com.series.app.shared.compose.throttledClickable

@Composable
fun SeriesListItem(
    series: SeriesModel,
    onNavigateToDetails: (Int) -> Unit,
) {
    Box(
        modifier = Modifier.throttledClickable(
            indication = rememberRipple(bounded = false),
            onThrottledClick = { onNavigateToDetails(series.id) })
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(2f / 3),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current)
                .data(series.image)
                .crossfade(true)
                .build(),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.8f))
                .padding(SeriesTheme.dimens.padding)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = series.name,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            )
            Spacer(modifier = Modifier.height(SeriesTheme.dimens.smallPadding))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(R.string.series_air_date_format, series.airDate),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = stringResource(R.string.series_rating_format, series.vote),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Icon(
                    modifier = Modifier.padding(start = SeriesTheme.dimens.smallPadding),
                    imageVector = Icons.Sharp.Star,
                    tint = Color.Yellow,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
private fun SeriesListItemPreview() {
    SeriesListItem(
        series = MockSeriesModel.DEFAULT,
        onNavigateToDetails = {})
}
