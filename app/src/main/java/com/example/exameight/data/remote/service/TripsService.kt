package com.example.homeworktwentyone.data.remote.service

import com.example.exameight.data.remote.model.TripDto
import retrofit2.Response
import retrofit2.http.GET

interface TripsService {

    @GET("0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getTrips(): Response<List<TripDto>>


}