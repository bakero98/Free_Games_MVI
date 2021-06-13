package com.balsa.free_games.utils.extensions

import android.widget.TextView
import androidx.annotation.StringRes

fun TextView.loadString(@StringRes stringRes: Int) {
    this.text = this.context.getString(stringRes)
}