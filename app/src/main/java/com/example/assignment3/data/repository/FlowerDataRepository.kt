package com.example.assignment3.data.repository

import com.example.assignment3.domain.Flower

interface FlowerDataRepository {
    suspend fun getAllFlowers(): List<Flower>
    suspend fun getFlowerById(id: String): Flower?
}