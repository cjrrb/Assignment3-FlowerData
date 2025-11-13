package com.example.assignment3_flowerdata.data.remote

import retrofit2.http.GET

interface FlowerDataApi {
    @GET("flowers.json")
    suspend fun getRemoteData(): RemoteData
}