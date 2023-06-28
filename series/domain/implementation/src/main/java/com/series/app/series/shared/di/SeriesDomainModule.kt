package com.series.app.series.shared.di

import com.series.app.series.shared.usecase.*
import org.koin.dsl.module

val seriesDomainModule = module {
    factory<GetSeriesUseCase> { GetSeriesUseCaseImpl(get()) }
    factory<ObserveSeriesUseCase> { ObserveSeriesUseCaseImpl(get()) }
    factory<GetSeriesDetailsUseCase> { GetSeriesDetailsUseCaseImpl(get()) }
    factory<LoadMoreSeriesUseCase> { LoadMoreSeriesUseCaseImp(get()) }
}
