package com.series.app.series.shared.usecase

import com.series.app.series.shared.SeriesRepository
import com.series.app.series.shared.wrapToResult

class GetSeriesUseCase internal constructor(private val seriesService: SeriesRepository) {

    suspend operator fun invoke() = wrapToResult { seriesService.getSeries() }
}
