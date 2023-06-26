package com.series.app.series.shared.usecase

import com.series.app.series.shared.SeriesRepository

class ObserveSeriesUseCase internal constructor(private val seriesRepository: SeriesRepository) {
    operator fun invoke() = seriesRepository.observeSeries()
}
