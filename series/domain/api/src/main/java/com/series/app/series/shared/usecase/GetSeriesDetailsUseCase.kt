package com.series.app.series.shared.usecase

import com.series.app.series.shared.model.SeriesDetailModel
import com.series.app.shared.ResultWrapper

interface GetSeriesDetailsUseCase {
    suspend operator fun invoke(seriesId:Int): ResultWrapper<SeriesDetailModel>
}
