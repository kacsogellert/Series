package com.series.app.series.shared.usecase

import com.series.app.shared.ResultWrapper

interface GetSeriesUseCase {
    suspend operator fun invoke(): ResultWrapper<Unit>
}
