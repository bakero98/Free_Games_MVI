package com.balsa.free_games.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.balsa.free_games.databinding.ActivityMainBinding
import com.balsa.free_games.ui.base.BaseActivity
import com.balsa.free_games.utils.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainState, MainEvent, MainAction>() {

    private val viewModel: MainViewModel by viewModels()

    override fun provideViewModel() = viewModel

    override fun doBinding() = viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun render(state: MainState) = Unit

    override fun onEvent(event: MainEvent) = Unit
}