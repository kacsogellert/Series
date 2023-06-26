package com.series.app.series.data.di

import com.series.app.series.data.SeriesRepositoryImplementation
import com.series.app.series.data.service.SeriesNetworkService
import com.series.app.series.data.source.SeriesRemoteSource
import com.series.app.series.shared.SeriesRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val seriesDataModule = module {
    single<SeriesRepository> { SeriesRepositoryImplementation(get()) }
    factory { SeriesRemoteSource(get()) }
    factory { get<Retrofit>().create(SeriesNetworkService::class.java) }
}
