package com.balsa.free_games.ui.reusable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balsa.free_games.data.models.ImageModel
import com.balsa.free_games.databinding.ItemGameImageBinding
import com.balsa.free_games.utils.extensions.loadImage

object ImageModelDiffUtil : DiffUtil.ItemCallback<ImageModel>() {
    override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel) =
        oldItem == newItem

}

class ImagesRecyclerAdapter : ListAdapter<ImageModel, ImageViewHolder>(ImageModelDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemGameImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ImageViewHolder(private val binding: ItemGameImageBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(image: ImageModel) {
        binding.image.loadImage(
            url = image.image,
            placeholder = null
        )
    }
}