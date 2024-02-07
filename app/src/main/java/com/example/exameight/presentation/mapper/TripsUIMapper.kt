package com.example.exameight.presentation.mapper

import com.example.exameight.domain.model.Trip
import com.example.exameight.presentation.model.TripUI

fun Trip.toPresentation() = TripUI(
    id = id,
    cover = cover,
    price = price,
    title = title,
    location = location,
    reactionCount = reactionCount,
    rate = rate
)