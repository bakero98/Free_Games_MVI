package com.balsa.free_games.ui.gameslist

import com.balsa.free_games.ui.base.BaseAction

sealed class GamesListAction : BaseAction {
    class OpenGameDetails(val gameId: Long) : GamesListAction()

    object Init : GamesListAction()
}