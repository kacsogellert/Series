package com.series.app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.series.app.shared.SeriesTheme
import com.series.app.ui.compose.SeriesErrorSection
import com.series.app.ui.compose.SeriesFullScreenLoading
import com.series.app.ui.compose.SeriesListItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun SeriesScreen(
    viewModel: SeriesViewModel = koinViewModel(),
    onNavigateToDetails: (Int) -> Unit
) {
    when {
        viewModel.loadingVisible.value -> SeriesFullScreenLoading()
        viewModel.errorVisible.value -> SeriesErrorSection(viewModel::onTryAgainClick)

        else -> {
            val listState = rememberLazyListState()
            val shouldLoadMore = remember { derivedStateOf { listState.firstVisibleItemIndex >= viewModel.seriesList.value.lastIndex - 4 } }

            LazyColumn(state = listState) {
                items(viewModel.seriesList.value) { series ->
                    SeriesListItem(
                        series = series,
                        onNavigateToDetails = onNavigateToDetails,
                    )
                    if (shouldLoadMore.value) {
                        viewModel.onLoadMore()
                    }
                }
                if (viewModel.loadMoreVisible.value) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(SeriesTheme.dimens.padding)
                        ) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                    }
                }
            }
        }
    }
}
