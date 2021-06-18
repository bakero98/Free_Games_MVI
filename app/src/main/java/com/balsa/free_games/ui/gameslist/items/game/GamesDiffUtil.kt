package com.balsa.free_games.ui.gameslist.items.game

import androidx.recyclerview.widget.DiffUtil
import com.balsa.free_games.data.uimodels.GameUiModel
import com.balsa.free_games.ui.gameslist.items.ItemModel

object GamesDiffUtil : DiffUtil.ItemCallback<ItemModel.Game>() {
    override fun areItemsTheSame(oldItem: ItemModel.Game, newItem: ItemModel.Game) =
        oldItem.game.id == newItem.game.id

    override fun areContentsTheSame(oldItem: ItemModel.Game, newItem: ItemModel.Game) =
        oldItem.game == newItem.game
}