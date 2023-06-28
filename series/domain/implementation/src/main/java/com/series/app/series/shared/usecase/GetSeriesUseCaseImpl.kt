package com.series.app.series.shared.usecase

import com.series.app.series.shared.SeriesRepository
import com.series.app.shared.wrapToResult

internal class GetSeriesUseCaseImpl internal constructor(private val seriesService: SeriesRepository) : GetSeriesUseCase {
    override suspend operator fun invoke() = wrapToResult { seriesService.getSeries() }
}
