package com.balsa.free_games.ui.gamedetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.balsa.free_games.R
import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.databinding.FragmentGameDetailsBinding
import com.balsa.free_games.ui.base.BaseFragment
import com.balsa.free_games.ui.reusable.ImagesRecyclerAdapter
import com.balsa.free_games.utils.extensions.loadImageDrawableCompat
import com.balsa.free_games.utils.extensions.setPagerSnapHelper
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
    private val gameImagesAdapter = ImagesRecyclerAdapter()

    override fun provideViewModel() = viewModel

    override fun doBinding() = viewBinding(FragmentGameDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.executeAction(GameDetailsAction.Init(args.gameId))
    }

    private fun initUi(game: GameUiModel) {
        with(binding) {
            gameName.text = game.title

            imagesRecycler.adapter = gameImagesAdapter
            gameImagesAdapter.submitList(game.screenshots)

            imagesRecycler.setPagerSnapHelper()
            platformImage.loadImageDrawableCompat(game.platform.drawableRes)
        }
    }

    override fun render(state: GameDetailsState) = Unit
    override fun onEvent(event: GameDetailsEvent) {
        when(event) {
            is GameDetailsEvent.GameLoaded -> {
                initUi(event.game)
            }
        }
    }
}