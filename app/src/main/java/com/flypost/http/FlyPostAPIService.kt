package com.flypost.http

import retrofit2.http.GET
import retrofit2.http.Path

interface FlyPostAPIService {
    @GET("/deliveries/{userId}")
    suspend fun getDeliveries(@Path("userId") id: Int): List<Delivery>

    @GET("/office/{id}")
    suspend fun getOffice(@Path("id") id: Int): List<PostOffice>
}