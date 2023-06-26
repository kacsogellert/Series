package com.series.app.series.data

import com.series.app.series.data.source.SeriesRemoteSource
import com.series.app.series.shared.SeriesRepository
import com.series.app.series.shared.model.SeriesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.update

internal class SeriesRepositoryImplementation(private val remoteSource: SeriesRemoteSource) : SeriesRepository {
    private val seriesFlow = MutableStateFlow<List<SeriesModel>?>(null)
    private var page = 1

    override fun observeSeries(): Flow<List<SeriesModel>> = seriesFlow.mapNotNull { it }

    override suspend fun getSeries() {
        remoteSource.getSeries(page).also { series ->
            page += 1
            seriesFlow.update { series }
        }
    }

    override suspend fun loadMoreSeries() {
        remoteSource.getSeries(page).also { series ->
            seriesFlow.update { it?.plus(series) }
            page += 1
        }
    }

    override suspend fun getSeriesDetail(id: Int) = remoteSource.getSeriesDetail(id)
}
