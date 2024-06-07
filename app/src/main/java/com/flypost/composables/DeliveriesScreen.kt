package com.flypost.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.flypost.http.Delivery
import com.flypost.ui.theme.Yellow
import com.flypost.viewModels.DeliveriesViewModel
import kotlinx.serialization.Serializable

@Serializable
object DeliveriesScreen

@Composable
fun DeliveriesScreen(onClickDelivery: (Delivery) -> Unit, deliveriesViewModel: DeliveriesViewModel = viewModel()) {
    val deliveries = deliveriesViewModel.deliveries
    Scaffold(
        topBar = { TopBar() }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(deliveries.size) {
                //Text(text = deliveries[it].toString())
                Delivery(delivery = deliveries[it], onClickDelivery)
            }
            if (deliveries.isEmpty()){
                item{
                    Text(
                        text = "У вас немає активних доставок",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


@Composable
fun Delivery(delivery: Delivery, onClickDelivery: (Delivery) -> Unit) {
    Column(
        Modifier
            .clickable {
                onClickDelivery(delivery)
            }
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp) // Padding outside the border
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(7.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = String.format("%08d", delivery.id),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = delivery.current_position)
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "",
                Modifier
                    .height(51.dp)
                    .weight(2f)
                    .padding(end = 15.dp),
                overflow = TextOverflow.Ellipsis
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Yellow,
                    disabledContainerColor = Color(0x10000000)
                ),
                modifier = Modifier.weight(1f),
                enabled = delivery.payment_id == null
            ) {
                Text(text = if (delivery.payment_id == null) "Оплатити" else "Оплачено")
            }
        }
    }
}
