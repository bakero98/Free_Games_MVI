package com.balsa.free_games.data

import retrofit2.http.GET

interface ApiService {
    @GET("/api/games")
    suspend fun getGames()
}