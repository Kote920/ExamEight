package com.example.exameight.domain.model

import com.squareup.moshi.Json

data class Trip(
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val location: String,
    val reactionCount: Int,
    val rate: Int?,
)
