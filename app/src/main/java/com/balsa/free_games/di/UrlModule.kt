package com.balsa.free_games.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import javax.inject.Singleton

const val BASE_URL = "https://www.freetogame.com"

@Module
@InstallIn(ApplicationComponent::class)
object UrlModule {
    @Provides
    @Singleton
    fun provideBaseUrl() : HttpUrl {
        return BASE_URL.toHttpUrl()
    }
}