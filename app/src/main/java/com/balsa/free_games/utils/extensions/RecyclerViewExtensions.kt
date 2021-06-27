package com.balsa.free_games.utils.extensions

import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setPagerSnapHelper() {
    this.onFlingListener = null
    PagerSnapHelper().attachToRecyclerView(this)
}