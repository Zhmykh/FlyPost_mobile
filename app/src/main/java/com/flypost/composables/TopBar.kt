package com.flypost.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flypost.R
import com.flypost.ui.theme.Blue
import com.flypost.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "FLYPOST",
                color = White,
                fontSize = 26.sp
            )
        },
        navigationIcon = {
            Image(
                modifier = Modifier.height(50.dp).padding(7.dp, 0.dp, 0.dp, 0.dp),
                painter = painterResource(id = R.drawable.logo_white),
                contentDescription = null
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = null
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Blue,
            actionIconContentColor = White
        ))
}