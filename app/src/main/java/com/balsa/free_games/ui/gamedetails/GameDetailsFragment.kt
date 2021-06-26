package com.balsa.free_games.ui.gamedetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.balsa.free_games.R
import com.balsa.free_games.databinding.FragmentGameDetailsBinding
import com.balsa.free_games.ui.base.BaseFragment
import com.balsa.free_games.utils.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetailsFragment :
    BaseFragment<
            FragmentGameDetailsBinding,
            GameDetailsState,
            GameDetailsEvent,
            GameDetailsAction
            >(R.layout.fragment_game_details) {

    private val viewModel: GameDetailsViewModel by viewModels()
    private val args: GameDetailsFragmentArgs by navArgs()

    override fun provideViewModel() = viewModel

    override fun doBinding() = viewBinding(FragmentGameDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.executeAction(GameDetailsAction.Init(args.gameId))
    }

    companion object {

    }

    override fun render(state: GameDetailsState) = Unit
    override fun onEvent(event: GameDetailsEvent) = Unit
}