package com.balsa.free_games.ui.gameslist

import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.ui.base.BaseState
import com.balsa.free_games.ui.gameslist.items.ItemModel

sealed class GamesListState : BaseState {
    class GamesLoaded(val games: List<ItemModel>) : GamesListState()
}