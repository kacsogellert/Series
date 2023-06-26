package com.series.app.series.data.model

import com.google.gson.annotations.SerializedName
import com.series.app.series.data.util.ImageType
import com.series.app.series.data.util.getImageKey
import com.series.app.series.shared.model.SeriesModel

internal data class SeriesResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("vote_count") val voteCount: Int?,
    @SerializedName("first_air_date") val airDate: String?,
)

internal fun convertToModel(seriesResponse: SeriesResponse) = SeriesModel(
    id = seriesResponse.id ?: 0,
    name = seriesResponse.name.orEmpty(),
    image = seriesResponse.posterPath?.getImageKey(ImageType.ORIGINAL).orEmpty(),
    vote = seriesResponse.voteAverage ?: 0.0,
    airDate = seriesResponse.airDate.orEmpty(),
)
