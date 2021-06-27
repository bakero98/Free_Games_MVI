package com.balsa.free_games.ui.gamedetails

import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.ui.base.BaseEvent

sealed class GameDetailsEvent : BaseEvent {
    class GameLoaded(val game: GameUiModel) : GameDetailsEvent()
}