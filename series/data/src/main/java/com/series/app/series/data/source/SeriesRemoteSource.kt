package com.series.app.series.data.source

import com.series.app.series.data.model.convertToModel
import com.series.app.series.data.service.SeriesNetworkService
import com.series.app.series.shared.model.SeriesModel

internal class SeriesRemoteSource constructor(private val networkService: SeriesNetworkService) {

    suspend fun getSeries(page: Int): List<SeriesModel> = networkService.getSeries(page).seriesResponseList.map(::convertToModel)

    suspend fun getSeriesDetail(seriesId: Int) = networkService.getSeriesId(seriesId).let(::convertToModel)
}
