package com.balsa.free_games.data

import com.balsa.free_games.data.models.GameModel
import com.balsa.free_games.data.uimodels.GameUiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/games")
    suspend fun getGames() : List<GameModel>

    @GET("/api/game")
    suspend fun getGameDetails(
        @Query("id") id: Long
    ) : GameModel
}