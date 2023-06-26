package com.series.app.series.data.util

private const val basePath: String = "https://image.tmdb.org/t/p"

enum class ImageType { ORIGINAL, PROFILE }

fun String.getImageKey(imageType: ImageType) = when (imageType) {
    ImageType.ORIGINAL -> "$basePath/original/$this"
    ImageType.PROFILE -> "$basePath/w235_and_h235_face/$this"
}
