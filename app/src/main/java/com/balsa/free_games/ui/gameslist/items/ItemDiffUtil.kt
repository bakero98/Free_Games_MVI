package com.balsa.free_games.ui.gameslist.items

import androidx.recyclerview.widget.DiffUtil
import com.balsa.free_games.ui.gameslist.items.categories.FeedCategoriesDiffUtil
import com.balsa.free_games.ui.gameslist.items.game.GamesDiffUtil

object ItemDiffUtil : DiffUtil.ItemCallback<ItemModel>(){
    override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return if(oldItem::class != newItem::class){
            false
        }else{
            when(oldItem) {
                is ItemModel.Game -> {
                    GamesDiffUtil.areItemsTheSame(oldItem, newItem as ItemModel.Game)
                }
                is ItemModel.Category -> {
                    FeedCategoriesDiffUtil.areItemsTheSame(oldItem, newItem as ItemModel.Category)
                }
            }
        }
    }

    override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return if(oldItem::class != newItem::class) {
            false
        } else {
            when(oldItem) {
                is ItemModel.Game -> {
                    GamesDiffUtil.areContentsTheSame(oldItem, newItem as ItemModel.Game)
                }
                is ItemModel.Category -> {
                    FeedCategoriesDiffUtil.areContentsTheSame(oldItem, newItem as ItemModel.Category)
                }
            }
        }
    }
}