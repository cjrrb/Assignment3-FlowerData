package com.example.assignment3_flowerdata.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class RemoteData(
    val flowers: List<RemoteFlower>
)
