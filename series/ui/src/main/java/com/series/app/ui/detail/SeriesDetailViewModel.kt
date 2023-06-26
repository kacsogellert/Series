package com.series.app.ui.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.series.app.series.shared.model.SeriesDetailModel
import com.series.app.series.shared.usecase.GetSeriesDetailsUseCase
import com.series.app.shared.ResultWrapper
import com.series.app.shared.NavigationDestination
import kotlinx.coroutines.launch

class SeriesDetailViewModel constructor(
    savedStateHandle: SavedStateHandle,
    private val getSeriesDetailsUseCase: GetSeriesDetailsUseCase
) : ViewModel() {

    private val seriesId: Int = checkNotNull(savedStateHandle[NavigationDestination.SeriesDetails.SERIES_ID])

    val loadingVisible = mutableStateOf(true)
    val seriesDetail = mutableStateOf<SeriesDetailModel?>(null)

    init {
        downloadSeriesDetail()
    }

    private fun downloadSeriesDetail() {
        viewModelScope.launch {
            loadingVisible.value = true
            when (val response = getSeriesDetailsUseCase(seriesId)) {
                is ResultWrapper.Exception -> loadingVisible.value = false
                is ResultWrapper.Success -> {
                    seriesDetail.value = response.data
                    loadingVisible.value = false
                }
            }
        }
    }
}
