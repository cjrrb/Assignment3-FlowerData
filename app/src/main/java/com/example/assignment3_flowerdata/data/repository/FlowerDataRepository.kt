package com.example.assignment3_flowerdata.data.repository

import com.example.assignment3_flowerdata.domain.Flower

interface FlowerDataRepository {
    suspend fun getAllFlowers(): List<Flower>
    suspend fun getFlowerById(id: String): Flower?
}