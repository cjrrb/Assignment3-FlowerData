package com.example.assignment3.data.remote

import retrofit2.http.GET

interface FlowerDataApi {
    @GET("flowers.json")
    suspend fun getRemoteData(): RemoteData
}