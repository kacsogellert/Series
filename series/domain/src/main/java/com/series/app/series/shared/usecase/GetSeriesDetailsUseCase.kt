package com.series.app.series.shared.usecase

import com.series.app.series.shared.SeriesRepository
import com.series.app.shared.wrapToResult

class GetSeriesDetailsUseCase internal constructor(private val seriesService: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int) = wrapToResult { seriesService.getSeriesDetail(seriesId) }
}
