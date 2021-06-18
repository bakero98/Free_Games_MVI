package com.balsa.free_games.data.usecases

import com.balsa.free_games.data.ApiService
import com.balsa.free_games.data.uimodels.GameUiModel
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun execute() : List<GameUiModel> {
        return apiService.getGames().map { it.mapTopGameUiModel() }
    }
}