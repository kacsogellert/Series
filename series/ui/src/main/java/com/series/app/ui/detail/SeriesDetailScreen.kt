package com.series.app.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.series.app.series.ui.R
import com.series.app.shared.SeriesTheme
import com.series.app.ui.compose.SeriesBackIcon
import com.series.app.ui.compose.SeriesFullScreenLoading
import com.series.app.ui.compose.SeriesGenreChip
import org.koin.androidx.compose.koinViewModel

@Composable
fun SeriesDetailsScreen(
    viewModel: SeriesDetailViewModel = koinViewModel(),
    onUpClick: () -> Unit
) {
    val detailModel = viewModel.seriesDetail.value
    when {
        viewModel.loadingVisible.value -> SeriesFullScreenLoading()
        detailModel != null -> {
            val scrollState = rememberScrollState()
            Box {
                Column(modifier = Modifier.verticalScroll(scrollState)) {
                    AsyncImage(
                        modifier = Modifier
                            .aspectRatio(2f / 2)
                            .graphicsLayer { translationY = 0.3f * scrollState.value },
                        contentScale = ContentScale.Crop,
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(detailModel.posterImage)
                            .crossfade(true)
                            .build(),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(SeriesTheme.dimens.smallPadding))
                    Card {
                        Column(Modifier.padding(SeriesTheme.dimens.contentPadding)) {
                            Text(
                                text = stringResource(R.string.series_title),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            )
                            Spacer(modifier = Modifier.height(SeriesTheme.dimens.smallPadding))
                            Text(
                                text = detailModel.originalName,
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                            Spacer(modifier = Modifier.height(SeriesTheme.dimens.contentPadding))

                            Text(
                                text = stringResource(R.string.series_overview),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            )
                            Spacer(modifier = Modifier.height(SeriesTheme.dimens.smallPadding))
                            Text(
                                text = detailModel.overview,
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                            Spacer(modifier = Modifier.height(SeriesTheme.dimens.contentPadding))
                            Text(
                                text = stringResource(R.string.series_genre),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            )
                            Spacer(modifier = Modifier.height(SeriesTheme.dimens.contentPadding))
                            Row {
                                detailModel.genres.forEach { genre ->
                                    SeriesGenreChip(genre)
                                    Spacer(modifier = Modifier.width(SeriesTheme.dimens.smallPadding))
                                }
                            }
                        }
                    }
                }
                SeriesBackIcon(onClick = onUpClick)
            }
        }
    }
}
