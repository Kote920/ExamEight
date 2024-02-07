package com.example.exameight.di

import com.example.exameight.domain.repository.GetTripsRepository
import com.example.exameight.domain.useCase.GetTripsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetTripsUseCase(getTripsRepository: GetTripsRepository): GetTripsUseCase {
        return GetTripsUseCase(getTripsRepository)
    }
}