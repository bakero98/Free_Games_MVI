package com.balsa.free_games.ui.gameslist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.data.usecases.GetGamesUseCase
import com.balsa.free_games.ui.base.BaseViewModel
import com.balsa.free_games.ui.gameslist.items.ItemModel
import com.balsa.free_games.utils.GENRE
import kotlinx.coroutines.launch

class GamesListViewModel @ViewModelInject constructor(
    private val getGamesUseCase: GetGamesUseCase
) : BaseViewModel<GamesListState, GamesListEvent, GamesListAction>() {

    private val uiList : MutableList<ItemModel> = arrayListOf()
    private var gamesList: MutableList<GameUiModel> = arrayListOf()
    private var categories = GENRE.getGenres().toList()

    override fun executeAction(action: GamesListAction) {
        super.executeAction(action)
        when(action) {
            is GamesListAction.Init -> {
                getGames()
            }
        }
    }

    private fun getGames() = viewModelScope.launch {
        gamesList = getGamesUseCase.execute().toMutableList()
        sortAndFillUiList()
    }

    private fun sortAndFillUiList() {
        uiList.add(ItemModel.Category(categories))

        gamesList.forEach{ game ->
            uiList.add(ItemModel.Game(game))
        }
        state.postValue(GamesListState.GamesLoaded(uiList))
    }
}