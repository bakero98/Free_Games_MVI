package com.balsa.free_games.utils.extensions

import android.widget.TextView
import androidx.annotation.StringRes
import java.util.Locale

fun TextView.loadString(@StringRes stringRes: Int) {
    this.text = this.context.getString(stringRes)
}

fun TextView.loadAllCapsString(@StringRes stringRes: Int) {
    this.text = this.context.getString(stringRes).toUpperCase(Locale.ROOT)
}