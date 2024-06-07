package com.flypost

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.flypost.composables.DeliveriesScreen
import com.flypost.composables.DeliveryInfoScreen
import com.flypost.composables.TopBar
import com.flypost.dataclasses.DeliverySerializable
import com.flypost.dataclasses.deliveryToSerializable
import com.flypost.http.Delivery
import com.flypost.ui.theme.FlyPostTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSharedPreferences("MyShP", MODE_PRIVATE).edit().putInt("client_id", 1).apply()


        setContent {
            val navController = rememberNavController();
            val app = this.application
            NavHost(navController = navController, startDestination = DeliveriesScreen){
                composable<DeliveriesScreen> {
                    DeliveriesScreen(onClickDelivery = {
                        navController.navigate(deliveryToSerializable(it))
                    })
                }
                composable<DeliverySerializable> {
                    DeliveryInfoScreen(
                        deliverySerializable = it.toRoute<DeliverySerializable>(),
                        application = app
                    )
                }
            }
        }
    }
}

@Composable
fun Auth() {
    val email = remember{mutableStateOf("")}
    FlyPostTheme {

        Scaffold(
            topBar = { TopBar() }
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Column(
                    modifier = Modifier.width(300.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Авторизуйтеся в системі")
                    Spacer(modifier = Modifier.height(30.dp))
                    TextField(
                        value = email.value,
                        onValueChange = { s: String -> email.value = s },
                        placeholder = { Text("Email") },
                        label = {Text("Електронна пошта")},
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AuthPreview() {
    Auth()
}
