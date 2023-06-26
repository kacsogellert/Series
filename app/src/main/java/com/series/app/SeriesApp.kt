package com.series.app

import android.app.Application
import com.series.app.series.data.di.seriesDataModule
import com.series.app.series.shared.di.seriesDomainModule
import com.series.app.shared.createNetworkModule
import com.series.app.ui.di.seriesUiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SeriesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SeriesApp)
            modules(
                listOf(
                    seriesUiModule,
                    seriesDomainModule,
                    seriesDataModule,
                    createNetworkModule(
                        isDebug = BuildConfig.DEBUG,
                        baseUrl = BuildConfig.SERIES_ENDPOINT
                    )
                )
            )
        }
    }
}
