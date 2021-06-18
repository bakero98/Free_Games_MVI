package com.balsa.free_games.ui.gameslist.items.game

import androidx.recyclerview.widget.RecyclerView
import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.databinding.ItemCardGameBinding
import com.balsa.free_games.utils.extensions.loadAllCapsString
import com.balsa.free_games.utils.extensions.loadImage
import com.balsa.free_games.utils.extensions.loadImageDrawableCompat

class GameViewHolder(val binding: ItemCardGameBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        game: GameUiModel
    ) {
        with(binding) {
            gameImage.loadImage(
                url = game.thumbnail,
                centerCrop = true
            )
            gameTitle.text = game.title
            genreImage.loadImageDrawableCompat(
                game.genre.drawableRes
            )
            gameDescription.text = game.shortDescription
            game.releaseDate?.let { releaseDate ->
                releaseGenreDetails.releaseDate.text = releaseDate.year.toString()
            }
            releaseGenreDetails.genre.loadAllCapsString(game.genre.labelRes)
        }
    }
}