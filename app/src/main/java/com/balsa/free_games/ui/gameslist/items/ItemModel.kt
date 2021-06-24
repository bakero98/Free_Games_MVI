package com.balsa.free_games.ui.gameslist.items

import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.utils.GENRE

sealed class ItemModel(var itemType: Int) {
    data class Game(var game: GameUiModel) : ItemModel(GAME_MODEL)
    data class Category(var categories: List<GENRE>) : ItemModel(CATEGORY)

    companion object {
        const val CATEGORY = 0
        const val GAME_MODEL = 1
    }
}