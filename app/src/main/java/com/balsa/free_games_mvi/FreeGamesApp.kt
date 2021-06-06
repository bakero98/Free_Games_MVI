package com.balsa.free_games_mvi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FreeGamesApp : Application() {
    companion object {
        var instance : FreeGamesApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}