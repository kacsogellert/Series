package com.series.app.series.data.model

import com.google.gson.annotations.SerializedName

internal data class SeriesContainerResponse(
    @SerializedName("results") val seriesResponseList: List<SeriesResponse>
)

