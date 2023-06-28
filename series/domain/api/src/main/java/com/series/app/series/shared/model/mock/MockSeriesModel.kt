package com.series.app.series.shared.model.mock

import com.series.app.series.shared.model.SeriesModel

object MockSeriesModel {
    val DEFAULT = SeriesModel(
        id = 1,
        name = "Mock Name",
        image = "https://image.tmdb.org/t/p/original//aOPhyvHDauWFuc3rthpHArCNyrm.jpg/",
        vote = 3.4,
        airDate = "2023-12-19",
    )
}
