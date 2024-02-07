package com.example.exameight.data.repository

import android.util.Log
import android.util.Log.d
import com.example.exameight.data.common.Resource
import com.example.exameight.data.remote.toDomain
import com.example.exameight.domain.model.Trip
import com.example.exameight.domain.repository.GetTripsRepository
import com.example.homeworktwentyone.data.remote.service.TripsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTripsRepositoryImpl @Inject constructor(
    private val tripsService: TripsService
) : GetTripsRepository {


    override suspend fun getTrips(): Flow<Resource<List<Trip>>> = withContext(Dispatchers.IO) {

        flow {
            try {
                emit(Resource.Loading())
                val response = tripsService.getTrips()
                d("errorRepository", "works at least")
                if (response.isSuccessful) {
                    val tripsList = response.body()!!
                    emit(Resource.Success(tripsList.map { it.toDomain() }))
                    d("errorRepository", "Success")
                } else {
                    d("errorRepository", "problem here")
                    emit(Resource.Failed("Failed!"))
                }

            }catch (e: Exception){
                emit(Resource.Failed("Error!"))
                d("errorRepository", e.toString())
            }
        }
    }
}