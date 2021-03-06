package com.balsa.free_games.data.usecases

import com.balsa.free_games.data.repositories.GamesRepository
import com.balsa.free_games.data.uimodels.GameUiModel
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val gamesRepository: GamesRepository
) {
    suspend fun execute() : List<GameUiModel> {
        return gamesRepository.getGames()
    }
}