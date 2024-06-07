package com.flypost.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flypost.ui.theme.FlyPostTheme

@Preview(showSystemUi = true)
@Composable
fun AuthScreen () {
    val email = remember{ mutableStateOf("") }
    FlyPostTheme {

        Scaffold(
            topBar = { TopBar() }
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center
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
                        label = { Text("Логін") },
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        value = email.value,
                        onValueChange = { s: String -> email.value = s },
                        placeholder = { Text("Email") },
                        label = { Text("Пароль") },
                        maxLines = 1
                    )
                }
            }
        }
    }
}