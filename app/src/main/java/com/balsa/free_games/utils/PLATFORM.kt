package com.balsa.free_games.utils

import androidx.annotation.DrawableRes
import com.balsa.free_games.R

enum class PLATFORM(
    @DrawableRes val drawableRes: Int,
    val names: List<String>
) {
    UNKNOWN(
        R.drawable.ic_question_mark,
        listOf()
    ),
    PC(
        R.drawable.ic_windows,
        listOf("Windows", "PC (Windows)")
    ),
    WEB(
        R.drawable.ic_world_wide_web,
        listOf("Web Browser")
    );

    companion object {
        fun getPlatformFromString(name: String) = values().firstOrNull { platform ->
            platform.names.contains(name)
        } ?: UNKNOWN
    }
}