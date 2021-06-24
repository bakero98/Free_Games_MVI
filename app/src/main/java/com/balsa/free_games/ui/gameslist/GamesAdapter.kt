package com.balsa.free_games.ui.gameslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balsa.free_games.databinding.ItemCardGameBinding
import com.balsa.free_games.databinding.ItemFeedCategoriesBinding
import com.balsa.free_games.ui.gameslist.items.ItemDiffUtil
import com.balsa.free_games.ui.gameslist.items.ItemModel
import com.balsa.free_games.ui.gameslist.items.categories.CategoriesViewHolder
import com.balsa.free_games.ui.gameslist.items.game.GameViewHolder

class GamesAdapter() : ListAdapter<ItemModel, RecyclerView.ViewHolder>(ItemDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ItemModel.GAME_MODEL -> {
                GameViewHolder(
                    ItemCardGameBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            ItemModel.CATEGORY -> {
                CategoriesViewHolder(
                    ItemFeedCategoriesBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw IllegalArgumentException("Not supported ItemModel")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is GameViewHolder -> {
                holder.bind((getItem(position) as ItemModel.Game).game)
            }
            is CategoriesViewHolder -> {
                holder.bind((getItem(position) as ItemModel.Category).categories)
            }
            else -> throw IllegalArgumentException("Not supported ItemModel")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) != null) getItem(position)!!.itemType else 0
    }

}