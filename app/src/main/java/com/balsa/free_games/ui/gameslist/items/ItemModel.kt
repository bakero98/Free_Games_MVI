package com.balsa.free_games.ui.gameslist.items

import com.balsa.free_games.data.uimodels.GameUiModel

sealed class ItemModel(var itemType: Int) {
    data class Game(var game: GameUiModel) : ItemModel(GAME_MODEL)

    companion object {
        const val GAME_MODEL = 0
    }
}