package com.example.assignment3_flowerdata.data.remote
@Serializable
data class RemoteFlower(
    val id: String,
    val label: String,
    val price: Double,
    val description: String,
    val picture: String,
    val wiki: String
)
