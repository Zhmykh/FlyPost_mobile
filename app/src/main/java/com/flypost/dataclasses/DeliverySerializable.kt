package com.flypost.dataclasses

import com.flypost.http.Delivery
import kotlinx.serialization.Serializable

@Serializable
data class DeliverySerializable (
    val current_position: String,
    val id: Int,
    val paid: Boolean,
    val price: Int,
    val send_date: String,
    val send_from: Int,
    val send_to: Int
)

fun deliveryToSerializable(delivery: Delivery): DeliverySerializable {
    return DeliverySerializable(
        delivery.current_position,
        delivery.id,
        delivery.payment_id != null,
        delivery.price,
        delivery.send_date,
        delivery.send_from,
        delivery.send_to
    )
}