package com.flypost.composables

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flypost.dataclasses.DeliverySerializable
import com.flypost.viewModels.DeliveryInfoViewModel
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DeliveryInfoScreen(
    deliverySerializable: DeliverySerializable,
    viewModel: DeliveryInfoViewModel = androidx.lifecycle.viewmodel.compose.viewModel<DeliveryInfoViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DeliveryInfoViewModel(deliverySerializable) as T
            }
        }
    ),
    application: Application
){
    var officeFrom = viewModel.officeFrom
    var officeTo = viewModel.officeTo

    Scaffold(
        topBar = { TopBar() }
    ) {
        Column (
            Modifier.padding(paddingValues = it)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = String.format("%08d", deliverySerializable.id),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = deliverySerializable.current_position)
                }
                Text(
                    text = "Відправлено: " + ZonedDateTime
                        .parse(deliverySerializable.send_date)
                        .format(DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss")),
                )
                Spacer(modifier = Modifier.height(30.dp))
                if (officeFrom != null && officeTo != null) {
                    Row (
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Маршрут:", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Button(onClick = {
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://maps.google.com/maps?saddr=" +
                                        officeFrom.cord_x + "," + officeFrom.cord_y +
                                        "&daddr=" +
                                        officeTo.cord_x + "," + officeTo.cord_y)
                            )
                            intent.`package` = "com.google.android.apps.maps"
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(application, intent, null)
                        }) {
                            Text(text = "Відстежити")
                        }
                    }
                    Row(
                        Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .padding(5.dp) // Padding outside the border
                            .border(
                                width = 2.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(7.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "№" + officeFrom.office_number + ", " + officeFrom.address)
                    }
                    Row(
                        Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .padding(5.dp) // Padding outside the border
                            .border(
                                width = 2.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(7.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "№" + officeTo.office_number + ", " + officeTo.address)
                    }
                }
            }
        }
    }
}
