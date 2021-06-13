package com.balsa.free_games.data

import com.balsa.free_games.data.models.GameModel
import retrofit2.http.GET

interface ApiService {
    @GET("/api/games")
    suspend fun getGames() : List<GameModel>
}