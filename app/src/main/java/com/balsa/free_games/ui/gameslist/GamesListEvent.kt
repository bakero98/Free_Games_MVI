package com.balsa.free_games.ui.gameslist

import com.balsa.free_games.ui.base.BaseEvent

sealed class GamesListEvent : BaseEvent {
    class OpenGameDetails(val gameId: Long) : GamesListEvent()
}