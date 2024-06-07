package com.flypost.http

data class Delivery(
    val current_position: String,
    val id: Int,
    val package_id: Int,
    val payment_id: Int?,
    val price: Int,
    val recipient_id: Int,
    val send_date: String,
    val claim_date: String?,
    val send_from: Int,
    val send_to: Int,
    val sender_id: Int
)
