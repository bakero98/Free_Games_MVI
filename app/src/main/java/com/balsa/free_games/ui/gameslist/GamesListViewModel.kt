package com.balsa.free_games.ui.gameslist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.balsa.free_games.data.usecases.GetGamesUseCase
import com.balsa.free_games.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class GamesListViewModel @ViewModelInject constructor(
    private val getGamesUseCase: GetGamesUseCase
) : BaseViewModel<GamesListState, GamesListEvent, GamesListAction>() {

    override fun executeAction(action: GamesListAction) {
        super.executeAction(action)
        when(action) {
            is GamesListAction.Init -> {
                getGames()
            }
        }
    }

    private fun getGames() = viewModelScope.launch {
        getGamesUseCase.execute()
    }
}