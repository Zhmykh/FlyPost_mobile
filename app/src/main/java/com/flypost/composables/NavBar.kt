package com.flypost.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flypost.R
import com.flypost.ui.theme.*

@Composable
fun NavBar(){
    NavigationBar(
        containerColor = Blue,
        modifier = Modifier.height(95.dp)
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.resource_package),
                    contentDescription = null,
                    tint = White
                )
            },
            label = {
                Text(
                    text = "Посилки",
                    color = White,
                    fontSize = 18.sp
                )
            },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = LightBlue
            )
        )
    }
}