package com.example.exameight.data.remote

import com.example.exameight.data.remote.model.TripDto
import com.example.exameight.domain.model.Trip

fun TripDto.toDomain() = Trip(
    id = id,
    cover = cover,
    price = price,
    title = title,
    location = location,
    reactionCount = reactionCount,
    rate = rate
)