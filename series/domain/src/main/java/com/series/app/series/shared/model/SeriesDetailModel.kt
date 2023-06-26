package com.series.app.series.shared.model

data class SeriesDetailModel(
    val id: Int,
    val backdropImage: String,
    val originalName: String,
    val posterImage: String,
    val overview: String,
    val genres: List<String>
)
