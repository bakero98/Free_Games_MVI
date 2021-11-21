package com.balsa.free_games.utils.extensions

import androidx.navigation.Navigation
import com.balsa.free_games.ui.gameslist.GamesListFragment
import com.balsa.free_games.ui.gameslist.GamesListFragmentDirections

fun GamesListFragment.goToGameDetails(gameId: Long) {
    Navigation.findNavController(this.requireView()).navigate(
        GamesListFragmentDirections.actionGamesListFragmentToGameDetailsFragment(gameId)
    )
}