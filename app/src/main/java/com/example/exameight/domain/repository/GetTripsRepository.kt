package com.example.exameight.domain.repository

import com.example.exameight.data.common.Resource
import com.example.exameight.domain.model.Trip
import kotlinx.coroutines.flow.Flow

interface GetTripsRepository {

    suspend fun getTrips(): Flow<Resource<List<Trip>>>
}