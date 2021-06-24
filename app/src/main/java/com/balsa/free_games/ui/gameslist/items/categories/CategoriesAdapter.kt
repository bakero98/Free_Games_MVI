package com.balsa.free_games.ui.gameslist.items.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balsa.free_games.R
import com.balsa.free_games.databinding.ItemCategoryBinding
import com.balsa.free_games.utils.Commons
import com.balsa.free_games.utils.GENRE
import com.balsa.free_games.utils.extensions.loadImageDrawableCompat

object CategoriesDiffUtil : DiffUtil.ItemCallback<GENRE>() {
    override fun areItemsTheSame(oldItem: GENRE, newItem: GENRE) = oldItem.name == newItem.name
    override fun areContentsTheSame(oldItem: GENRE, newItem: GENRE) = oldItem == newItem
}

class CategoriesAdapter : ListAdapter<GENRE, CategoryViewHolder>(CategoriesDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CategoryViewHolder(
    private val binding: ItemCategoryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        category: GENRE
    ) {
        with(binding) {
            categoryImage.loadImageDrawableCompat(category.drawableRes)
            categoryName.text = root.context.getString(category.labelRes).capitalize()
            if(category.isSelected == true) {
                categoryImage.borderColor = ContextCompat.getColor(
                    root.context,
                    R.color.chuck_colorPrimary
                )
                categoryImage.borderWidth = Commons.SELECTED_BORDER_WIDTH
            }else {
                categoryImage.borderColor = ContextCompat.getColor(
                    root.context,
                    R.color.black
                )
                categoryImage.borderWidth = Commons.NORMAL_BORDER_WIDTH
            }
        }
    }
}