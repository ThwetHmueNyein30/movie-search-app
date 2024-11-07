package com.thn.codingassessment.android.di

import com.thn.codingassessment.android.data.repository.MovieSearchRepository
import com.thn.codingassessment.android.data.repository.MovieSearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindRepository(repository: MovieSearchRepositoryImpl): MovieSearchRepository
}