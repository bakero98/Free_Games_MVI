package com.balsa.free_games.data.usecases

import com.balsa.free_games.data.ApiService
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun execute() {
        apiService.getGames()
    }
}