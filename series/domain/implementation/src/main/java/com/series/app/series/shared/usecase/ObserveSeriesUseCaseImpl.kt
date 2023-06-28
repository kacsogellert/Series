package com.series.app.series.shared.usecase

import com.series.app.series.shared.SeriesRepository

internal class ObserveSeriesUseCaseImpl internal constructor(private val seriesRepository: SeriesRepository) : ObserveSeriesUseCase {
    override operator fun invoke() = seriesRepository.observeSeries()
}
