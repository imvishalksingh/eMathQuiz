package com.productivityservicehub.emathquiz.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.productivityservicehub.emathquiz.DataClass.levels
import com.productivityservicehub.emathquiz.ui.theme.AccentColor
import com.productivityservicehub.emathquiz.ui.theme.Primary
import com.productivityservicehub.emathquiz.ui.theme.greenDark
import com.productivityservicehub.emathquiz.ui.theme.greenLight
import com.productivityservicehub.emathquiz.utils.LevelProgressManager

@Composable
fun Level(navController: NavController){
    LevelScreen(navController)
}

@Composable
fun LevelScreen(navController: NavController) {
    val context = LocalContext.current
    val highestLevelCompleted = LevelProgressManager.getHighestLevelCompleted(context)
    val levels = (1..100).toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Primary, AccentColor)))
            .padding(top = 30.dp, bottom = 50.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(26.dp),
        horizontalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        items(levels) { level ->
            LevelCard(level, highestLevelCompleted, navController)
        }
    }
}


@Composable
fun LevelCard(level: Int, highestLevelCompleted: Int, navController: NavController) {
    val isLocked = level > highestLevelCompleted + 1
    val isCompleted = level <= highestLevelCompleted

    val backgroundColor = when {
        isCompleted -> greenDark
        isLocked -> Color.White
        else -> greenLight
    }

    val cardColors = CardDefaults.cardColors(
        containerColor = backgroundColor,
        contentColor = Color.Black
    )

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(enabled = !isLocked) {
                if (!isLocked) {
                    navController.navigate("level_detail/$level")
                }
            },
        colors = cardColors,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Level $level",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
