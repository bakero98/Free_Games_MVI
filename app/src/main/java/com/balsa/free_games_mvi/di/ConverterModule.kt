package com.balsa.free_games_mvi.di

import com.balsa.free_games_mvi.data.serialization.OffsetDateTimeAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
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