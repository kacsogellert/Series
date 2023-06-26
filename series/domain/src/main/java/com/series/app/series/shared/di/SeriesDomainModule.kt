package com.series.app.series.shared.di

import com.series.app.series.shared.usecase.GetSeriesDetailsUseCase
import com.series.app.series.shared.usecase.GetSeriesUseCase
import com.series.app.series.shared.usecase.LoadMoreSeriesUseCase
import com.series.app.series.shared.usecase.ObserveSeriesUseCase
import org.koin.dsl.module

val seriesDomainModule = module {
    factory { GetSeriesUseCase(get()) }
    factory { ObserveSeriesUseCase(get()) }
    factory { GetSeriesDetailsUseCase(get()) }
    factory { LoadMoreSeriesUseCase(get()) }
}
