package com.series.app.ui.di

import com.series.app.ui.SeriesViewModel
import com.series.app.ui.detail.SeriesDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val seriesUiModule = module {
    viewModelOf(::SeriesViewModel)
    viewModelOf(::SeriesDetailViewModel)
}
