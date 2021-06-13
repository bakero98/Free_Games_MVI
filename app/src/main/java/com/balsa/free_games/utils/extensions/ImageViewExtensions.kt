package com.balsa.free_games.utils.extensions

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.balsa.free_games.R
import com.bumptech.glide.Glide

@JvmOverloads
fun <T> ImageView.loadImage(
    url: T?,
    @DrawableRes placeholder: Int? = R.drawable.placeholder_image,
    centerCrop: Boolean? = null
) {
    if (url != null && (url is String || url is Drawable || url is Uri)) {
        if (url is String) {
            url.replace("\\", "")
        }
        Glide.with(this.context)
            .also {
                it.load(url)
                    .also { load -> if (centerCrop != null && centerCrop) load.centerCrop() }
                    .also { load -> if (placeholder != null) load.placeholder(placeholder) }
                    .also { load -> load.into(this) }
            }
    }
}

fun ImageView.loadImageDrawableCompat(
    @DrawableRes imageDrawable: Int
) {
    this.setImageDrawable(ContextCompat.getDrawable(this.context, imageDrawable))
}