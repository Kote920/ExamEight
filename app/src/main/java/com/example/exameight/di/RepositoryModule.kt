package com.example.exameight.di

import com.example.exameight.data.repository.GetTripsRepositoryImpl
import com.example.exameight.domain.repository.GetTripsRepository
import com.example.homeworktwentyone.data.remote.service.TripsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGetTripsRepository(tripsService: TripsService): GetTripsRepository {
        return GetTripsRepositoryImpl(tripsService)
    }
}