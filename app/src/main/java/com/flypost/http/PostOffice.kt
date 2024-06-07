package com.flypost.http

import kotlinx.serialization.Serializable

@Serializable
data class PostOffice(
    val address: String,
    val city_id: Int,
    val cord_x: Double,
    val cord_y: Double,
    val id: Int,
    val office_number: Int
)