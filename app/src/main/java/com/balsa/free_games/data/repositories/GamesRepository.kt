package com.balsa.free_games.data.repositories

import com.balsa.free_games.data.ApiService
import com.balsa.free_games.data.uimodels.GameUiModel
import javax.inject.Inject

interface GamesRepository{
    suspend fun getGames() : List<GameUiModel>
    suspend fun getGameDetails(gameId: Long) : GameUiModel
}

class GamesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : GamesRepository {
    override suspend fun getGames(): List<GameUiModel> {
        return apiService.getGames().map { it.mapTopGameUiModel() }
    }

    override suspend fun getGameDetails(gameId: Long): GameUiModel {
        return apiService.getGameDetails(gameId).mapTopGameUiModel()
    }
}