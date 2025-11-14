package com.example.assignment3.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class RemoteData(
    val flowers: List<RemoteFlower>
)
