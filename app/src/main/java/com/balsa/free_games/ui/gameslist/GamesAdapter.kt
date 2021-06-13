package com.balsa.free_games.ui.gameslist


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.databinding.ItemCardGameBinding
import com.balsa.free_games.utils.extensions.loadImage
import com.balsa.free_games.utils.extensions.loadImageDrawableCompat
import com.balsa.free_games.utils.extensions.loadString

class GamesDiffUtil : DiffUtil.ItemCallback<GameUiModel>() {
    override fun areItemsTheSame(oldItem: GameUiModel, newItem: GameUiModel) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: GameUiModel, newItem: GameUiModel) = oldItem == newItem
}

class GamesAdapter() : ListAdapter<GameUiModel, GameViewHolder>(GamesDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            ItemCardGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

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
            releaseGenreDetails.genre.loadString(game.genre.labelRes)
        }
    }
}