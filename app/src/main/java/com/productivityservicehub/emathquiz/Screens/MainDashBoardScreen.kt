package com.productivityservicehub.emathquiz.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.productivityservicehub.emathquiz.Components.CardComp
import com.productivityservicehub.emathquiz.ui.theme.AccentColor
import com.productivityservicehub.emathquiz.ui.theme.Primary


@Composable
fun DashBoardScreen(navController: NavController){


        Column(modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Primary, AccentColor))),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardComp(navController)
        }


}

