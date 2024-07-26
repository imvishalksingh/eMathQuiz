package com.productivityservicehub.emathquiz.Screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CorrectAnswerScreen(levelNumber: Int, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Your answer is correct!", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val nextLevelNumber = levelNumber + 1
                if (nextLevelNumber <= 100) {
                    navController.navigate("level_detail/$nextLevelNumber") {
                        popUpTo("level_screen") { inclusive = false }
                    }
                } else {
                    navController.navigate("level_completed") {
                        popUpTo("level_screen") { inclusive = false }
                    }
                }
            }
        ) {
            Text("Go to Next Level")
        }
    }
}
