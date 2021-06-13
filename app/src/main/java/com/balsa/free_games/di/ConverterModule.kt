package com.balsa.free_games.di

import com.balsa.free_games.data.serialization.OffsetDateTimeAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ConverterModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(OffsetDateTimeAdapter())
            .build()
    }

    @Provides
    @Singleton
    fun provideConverter(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }
}