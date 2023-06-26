package com.series.app.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.series.app.series.shared.model.SeriesModel
import com.series.app.series.shared.usecase.GetSeriesUseCase
import com.series.app.series.shared.usecase.LoadMoreSeriesUseCase
import com.series.app.series.shared.usecase.ObserveSeriesUseCase
import com.series.app.shared.ResultWrapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SeriesViewModel(
    observeSeriesUseCase: ObserveSeriesUseCase,
    private val getSeriesUseCase: GetSeriesUseCase,
    private val loadMoreSeriesUseCase: LoadMoreSeriesUseCase,
) : ViewModel() {

    val seriesList = mutableStateOf<List<SeriesModel>>(emptyList())
    val loadingVisible = mutableStateOf(true)
    val errorVisible = mutableStateOf(false)
    var loadMoreVisible = mutableStateOf(false)

    init {
        loadData()

        observeSeriesUseCase()
            .onEach { seriesList.value = it }
            .catch { errorVisible.value = true }
            .launchIn(viewModelScope)
    }

    fun onLoadMore() {
        viewModelScope.launch {
            if (!loadMoreVisible.value) {
                loadMoreVisible.value = true
                delay(5000)
                when (loadMoreSeriesUseCase()) {
                    is ResultWrapper.Exception -> loadMoreVisible.value = false
                    is ResultWrapper.Success -> loadMoreVisible.value = false
                }
            }
        }
    }

    fun onTryAgainClick() {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            errorVisible.value = false
            loadingVisible.value = true
            when (getSeriesUseCase()) {
                is ResultWrapper.Exception -> {
                    errorVisible.value = true
                    loadingVisible.value = false
                }
                is ResultWrapper.Success -> loadingVisible.value = false
            }
        }
    }
}
