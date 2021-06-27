package com.balsa.free_games.di

import com.balsa.free_games.data.repositories.GamesRepository
import com.balsa.free_games.data.repositories.GamesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindGamesRepository(repository: GamesRepositoryImpl): GamesRepository
}