package com.balsa.free_games.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ClientModule {
    @Provides
    @Singleton
    fun provideClient(
        @ChuckLibInterceptor chuckLibInterceptor: Interceptor,
        @LoggingInterceptor loggingInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient().newBuilder()
        .apply {
            listOf(
                chuckLibInterceptor,
                loggingInterceptor
            ).forEach { interceptor ->
                this.addInterceptor(interceptor)
            }
        }
        .build()
}