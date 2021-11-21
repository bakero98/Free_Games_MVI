package com.balsa.free_games.ui.gameslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.balsa.free_games.R
import com.balsa.free_games.databinding.FragmentGamesListBinding
import com.balsa.free_games.ui.base.BaseFragment
import com.balsa.free_games.ui.gameslist.items.GamesListAdapterListener
import com.balsa.free_games.utils.extensions.goToGameDetails
import com.balsa.free_games.utils.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesListFragment :
    BaseFragment<FragmentGamesListBinding, GamesListState, GamesListEvent, GamesListAction>(R.layout.fragment_games_list) {

    private val viewModel: GamesListViewModel by viewModels()

    private val adapter = GamesAdapter(object : GamesListAdapterListener() {
        override fun onOpenGameDetails(gameId: Long) {
            super.onOpenGameDetails(gameId)
            viewModel.executeAction(GamesListAction.OpenGameDetails(gameId))
        }
    })

    override fun provideViewModel() = viewModel

    override fun doBinding() = viewBinding(FragmentGamesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        viewModel.executeAction(GamesListAction.Init)
    }

    private fun initUi() {
        with(binding) {
            gamesRecycler.adapter = adapter
        }
    }

    override fun render(state: GamesListState) {
        when (state) {
            is GamesListState.GamesLoaded -> {
                adapter.submitList(state.games)
            }
        }
    }

    override fun onEvent(event: GamesListEvent) {
        when (event) {
            is GamesListEvent.OpenGameDetails -> {
                goToGameDetails(event.gameId)
            }
        }
    }

}