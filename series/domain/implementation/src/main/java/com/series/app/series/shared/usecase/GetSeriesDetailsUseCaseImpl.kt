package com.series.app.series.shared.usecase

import com.series.app.series.shared.SeriesRepository
import com.series.app.series.shared.model.SeriesDetailModel
import com.series.app.shared.ResultWrapper
import com.series.app.shared.wrapToResult

internal class GetSeriesDetailsUseCaseImpl internal constructor(private val seriesService: SeriesRepository) : GetSeriesDetailsUseCase {
    override suspend fun invoke(seriesId: Int): ResultWrapper<SeriesDetailModel> = wrapToResult { seriesService.getSeriesDetail(seriesId) }
}
