package com.series.app.series.shared.usecase

import com.series.app.series.shared.SeriesRepository
import com.series.app.shared.wrapToResult

class LoadMoreSeriesUseCase internal constructor(private val seriesService: SeriesRepository) {
    suspend operator fun invoke() = wrapToResult { seriesService.loadMoreSeries() }
}
