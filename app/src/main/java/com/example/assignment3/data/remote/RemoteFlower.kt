package com.example.assignment3.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class RemoteFlower(
    val id: String,
    val label: String,
    val price: Double,
    val description: String,
    val picture: String,
    val wiki: String
)
