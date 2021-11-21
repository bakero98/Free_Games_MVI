package com.balsa.free_games.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageModel(
    @Json(name = "id") val id: Long?,
    @Json(name = "image") val image: String?
)