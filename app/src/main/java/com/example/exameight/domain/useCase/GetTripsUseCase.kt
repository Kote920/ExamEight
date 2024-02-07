package com.example.exameight.domain.useCase

import com.example.exameight.domain.repository.GetTripsRepository
import javax.inject.Inject

class GetTripsUseCase @Inject constructor(
    private val repository: GetTripsRepository
) {

    suspend operator fun invoke() = repository.getTrips()
}