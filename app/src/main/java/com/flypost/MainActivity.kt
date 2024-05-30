package com.flypost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.navigation.compose.rememberNavController
import com.flypost.ui.theme.FlyPostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val email = remember{mutableStateOf("")}
            FlyPostTheme {
                val navController = rememberNavController()
                //NavHost(navController = navController, startDestination = )
                Scaffold(
                    topBar = {TopBar()}
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
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlyPostTheme {
        Greeting("Android")
    }
}
