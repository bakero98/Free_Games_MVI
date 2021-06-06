package com.balsa.free_games_mvi.ui.gameslist

import android.os.Bundle
import androidx.activity.viewModels
import com.balsa.free_games_mvi.databinding.ActivityGamesListBinding
import com.balsa.free_games_mvi.ui.base.BaseActivity
import com.balsa.free_games_mvi.utils.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesListActivity : BaseActivity<ActivityGamesListBinding, GamesListState, GamesListEvent, GamesListAction>() {

    val viewModel : GamesListViewModel by viewModels()

    override fun doBinding() = viewBinding(ActivityGamesListBinding::inflate)

    override fun provideViewModel() = viewModel

    override fun render(state: GamesListState) = Unit

    override fun onEvent(event: GamesListEvent) = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}