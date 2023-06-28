package com.series.app.series.shared.usecase

import com.series.app.series.shared.model.SeriesModel
import kotlinx.coroutines.flow.Flow

interface ObserveSeriesUseCase {
    operator fun invoke(): Flow<List<SeriesModel>>
}
