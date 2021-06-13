package com.balsa.free_games.ui.gameslist

import android.os.Bundle
import androidx.activity.viewModels
import com.balsa.free_games.databinding.ActivityGamesListBinding
import com.balsa.free_games.ui.base.BaseActivity
import com.balsa.free_games.utils.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesListActivity :
    BaseActivity<ActivityGamesListBinding, GamesListState, GamesListEvent, GamesListAction>() {

    val viewModel: GamesListViewModel by viewModels()

    private val adapter = GamesAdapter()

    override fun doBinding() = viewBinding(ActivityGamesListBinding::inflate)

    override fun provideViewModel() = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    override fun onEvent(event: GamesListEvent) = Unit
}