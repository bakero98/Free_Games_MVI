package com.balsa.free_games.ui.gamedetails

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.data.usecases.GetGameDetailsUseCase
import com.balsa.free_games.ui.base.BaseViewModel
import com.balsa.free_games.utils.extensions.postEvent
import kotlinx.coroutines.launch

class GameDetailsViewModel @ViewModelInject constructor(
    private val getGameDetailsUseCase: GetGameDetailsUseCase
) : BaseViewModel<GameDetailsState, GameDetailsEvent, GameDetailsAction>() {

    private var game: GameUiModel? = null

    override fun executeAction(action: GameDetailsAction) {
        super.executeAction(action)
        when (action) {
            is GameDetailsAction.Init -> {
                getGameDetails(action.gameId)
            }
        }
    }

    private fun getGameDetails(gameId: Long) = viewModelScope.launch {
        game = getGameDetailsUseCase.execute(gameId)
        game?.let { game ->
            event.postEvent(GameDetailsEvent.GameLoaded(game))
        }
    }
}