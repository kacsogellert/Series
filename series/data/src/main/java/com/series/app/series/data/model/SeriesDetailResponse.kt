package com.series.app.series.data.model

import com.google.gson.annotations.SerializedName
import com.series.app.series.data.util.ImageType
import com.series.app.series.data.util.getImageKey
import com.series.app.series.shared.model.SeriesDetailModel

internal data class SeriesDetailResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("original_name") val originalName: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("genres") val genres: List<SeriesGenreResponse>?,
)

internal fun convertToModel(seriesResponse: SeriesDetailResponse) = SeriesDetailModel(
    id = seriesResponse.id ?: 0,
    backdropImage = seriesResponse.backdropPath?.getImageKey(ImageType.ORIGINAL).orEmpty(),
    posterImage = seriesResponse.posterPath?.getImageKey(ImageType.ORIGINAL).orEmpty(),
    overview = seriesResponse.overview.orEmpty(),
    originalName = seriesResponse.originalName.orEmpty(),
    genres = seriesResponse.genres?.mapNotNull { it.name }.orEmpty()
)
