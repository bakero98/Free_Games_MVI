package com.balsa.free_games_mvi.data

import retrofit2.http.GET

interface ApiService {
    @GET("/api/games")
    suspend fun getGames()
}