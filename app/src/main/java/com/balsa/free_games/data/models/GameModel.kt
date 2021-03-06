package com.balsa.free_games.data.models

import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.utils.GENRE
import com.balsa.free_games.utils.PLATFORM
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.threeten.bp.OffsetDateTime

@JsonClass(generateAdapter = true)
data class GameModel(
    @Json(name = "id") val id: Long,
    @Json(name = "title") val title: String,
    @Json(name = "thumbnail") val thumbnail: String,
    @Json(name = "short_description") val shortDescription: String,
    @Json(name = "description") val longDescription: String?,
    @Json(name = "game_url") val gameUrl : String,
    @Json(name = "genre") val genre: String,
    @Json(name = "platform") val platform: String,
    @Json(name = "publisher") val publisher: String,
    @Json(name = "developer") val developer: String,
    @Json(name = "release_date") val releaseDate: OffsetDateTime?,
    @Json(name = "freetogame_profile_url") val freetogameProfileUrl: String,
    @Json(name = "minimum_system_requirements") val systemRequirements: SystemRequirements?,
    @Json(name = "screenshots") val screenshots: List<ImageModel>?
) {
    fun mapTopGameUiModel() : GameUiModel {
        return GameUiModel().apply {
            id = this@GameModel.id
            title = this@GameModel.title
            thumbnail = this@GameModel.thumbnail
            shortDescription = this@GameModel.shortDescription
            gameUrl = this@GameModel.gameUrl
            genre = GENRE.getGenreFromString(this@GameModel.genre)
            platform = PLATFORM.getPlatformFromString(this@GameModel.platform)
            publisher = this@GameModel.publisher
            developer = this@GameModel.developer
            releaseDate = this@GameModel.releaseDate
            longDescription = this@GameModel.longDescription
            systemRequirements = this@GameModel.systemRequirements
            screenshots = this@GameModel.screenshots
        }
    }
}