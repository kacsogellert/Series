package com.series.app.series.data.service

import com.series.app.series.data.model.SeriesContainerResponse
import com.series.app.series.data.model.SeriesDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface SeriesNetworkService {
    @GET("tv/on_the_air")
    suspend fun getSeries(
        @Query("page") page: Int,
        @Query("language") language: String = "en-US"
    ): SeriesContainerResponse

    @GET("tv/{seriesId}")
    suspend fun getSeriesId(@Path("seriesId") seriesId: Int): SeriesDetailResponse
}
