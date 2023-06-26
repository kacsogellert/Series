package com.series.app.series.shared

import com.series.app.series.shared.model.SeriesDetailModel
import com.series.app.series.shared.model.SeriesModel
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {
    fun observeSeries(): Flow<List<SeriesModel>>

    suspend fun getSeries()

    suspend fun loadMoreSeries()

    suspend fun getSeriesDetail(id: Int): SeriesDetailModel
}
