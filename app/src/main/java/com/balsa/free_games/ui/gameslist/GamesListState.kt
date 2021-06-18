package com.balsa.free_games.ui.gameslist

import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.ui.base.BaseState

sealed class GamesListState : BaseState {
    class GamesLoaded(val games: List<GameUiModel>) : GamesListState()
}