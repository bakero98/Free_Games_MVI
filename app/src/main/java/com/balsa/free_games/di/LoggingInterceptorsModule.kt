package com.balsa.free_games.di

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object LoggingInterceptorsModule {

    @Provides
    @Singleton
    fun provideLogLevel(): HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY


    @Provides
    @Singleton
    @LoggingInterceptor
    fun provideLoggingInterceptor(level: HttpLoggingInterceptor.Level): Interceptor =
        HttpLoggingInterceptor().apply {
            this.level = level
        }

    @Provides
    @Singleton
    @ChuckLibInterceptor
    fun provideChuckInterceptor(@ApplicationContext context: Context): Interceptor {
        return ChuckInterceptor(context)
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LoggingInterceptor

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ChuckLibInterceptor
