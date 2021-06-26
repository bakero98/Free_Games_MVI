package com.balsa.free_games.ui.gamedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.balsa.free_games.R
import com.balsa.free_games.databinding.FragmentGameDetailsBinding
import com.balsa.free_games.ui.base.BaseFragment
import com.balsa.free_games.ui.base.BaseViewModel
import com.balsa.free_games.utils.extensions.FragmentViewBindingDelegate
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

    override fun provideViewModel() = viewModel

    override fun doBinding() = viewBinding(FragmentGameDetailsBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_details, container, false)
    }

    companion object {

    }
    
    override fun render(state: GameDetailsState) = Unit
    override fun onEvent(event: GameDetailsEvent) = Unit
}