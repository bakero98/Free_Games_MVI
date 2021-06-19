package com.balsa.free_games.ui.gameslist.items.categories

import androidx.recyclerview.widget.RecyclerView
import com.balsa.free_games.databinding.ItemFeedCategoriesBinding
import com.balsa.free_games.utils.GENRE

class CategoriesViewHolder(
    private val binding: ItemFeedCategoriesBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        categories: List<GENRE>
    ) {
        with(binding) {
            val adapter = CategoriesAdapter()
            categoriesRecycler.adapter = adapter
            adapter.submitList(categories)
        }
    }
}