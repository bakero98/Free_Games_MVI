package com.balsa.free_games.data.uimodels

import com.balsa.free_games.data.models.ImageModel
import com.balsa.free_games.data.models.SystemRequirements
import com.balsa.free_games.utils.GENRE
import com.balsa.free_games.utils.PLATFORM
import org.threeten.bp.OffsetDateTime

data class GameUiModel(
    var id: Long = 0,
    var title: String = "",
    var thumbnail: String = "",
    var shortDescription: String = "",
    var gameUrl : String = "",
    var genre: GENRE = GENRE.UNKNOWN,
    var platform: PLATFORM = PLATFORM.UNKNOWN,
    var publisher: String = "",
    var developer: String = "",
    var releaseDate: OffsetDateTime? = null,
    var longDescription: String? = "",
    var systemRequirements: SystemRequirements? = null,
    var screenshots: List<ImageModel>? = null
)