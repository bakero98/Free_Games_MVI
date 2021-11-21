package com.balsa.free_games.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SystemRequirements(
    @Json(name = "os") val os: String?,
    @Json(name = "processor") val processor: String?,
    @Json(name = "memory") val memory: String?,
    @Json(name = "graphics") val graphics: String?,
    @Json(name = "storage") val storage: String?,
)