package com.series.app.series.shared.usecase

import com.series.app.series.shared.SeriesRepository
import com.series.app.shared.wrapToResult

internal class LoadMoreSeriesUseCaseImp internal constructor(private val seriesService: SeriesRepository) : LoadMoreSeriesUseCase {
    override suspend operator fun invoke() = wrapToResult { seriesService.loadMoreSeries() }
}
