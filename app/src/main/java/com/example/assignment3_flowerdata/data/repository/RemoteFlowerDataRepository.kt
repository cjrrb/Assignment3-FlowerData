package com.example.assignment3_flowerdata.data.repository

import com.example.assignment3_flowerdata.data.remote.FlowerDataApi
import com.example.assignment3_flowerdata.data.remote.RemoteData
import com.example.assignment3_flowerdata.data.remote.RemoteFlower
import com.example.assignment3_flowerdata.data.remote.imageFolder
import com.example.assignment3_flowerdata.domain.Flower
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteFlowerDataRepository @Inject constructor(
    private val flowerDataApi: FlowerDataApi
): FlowerDataRepository {
    override suspend fun getAllFlowers(): List<Flower> =
        withContext(Dispatchers.IO) {
            val remoteData: RemoteData = flowerDataApi.getRemoteData()
            remoteData.flowers.map { remoteFlower -> remoteFlower.toFlower() }
        }

    override suspend fun getFlowerById(id: String): Flower? {
        return getAllFlowers().find { flower -> flower.id == id }
    }
}

fun RemoteFlower.toFlower() = Flower(
    id = this.id,
    label = this.label,
    price = this.price,
    description = this.description,
    picture = imageFolder + this.picture,
    wiki = this.wiki
)