package com.balsa.free_games.ui.gamedetails

import com.balsa.free_games.ui.base.BaseViewModel

class GameDetailsViewModel : BaseViewModel<GameDetailsState, GameDetailsEvent, GameDetailsAction>(){

    override fun executeAction(action: GameDetailsAction) {
        super.executeAction(action)
        when(action) {
            is GameDetailsAction.Init -> {
            }
        }
    }
}