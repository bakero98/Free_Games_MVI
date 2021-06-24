package com.balsa.free_games.ui.gameslist.items.categories

import androidx.recyclerview.widget.DiffUtil
import com.balsa.free_games.ui.gameslist.items.ItemModel

object FeedCategoriesDiffUtil : DiffUtil.ItemCallback<ItemModel.Category>() {
    override fun areItemsTheSame(
        oldItem: ItemModel.Category,
        newItem: ItemModel.Category
    ) = oldItem.categories == newItem.categories

    override fun areContentsTheSame(
        oldItem: ItemModel.Category,
        newItem: ItemModel.Category
    ) = oldItem == newItem
}