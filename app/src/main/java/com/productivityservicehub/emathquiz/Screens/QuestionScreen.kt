package com.productivityservicehub.emathquiz.Screens


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.productivityservicehub.emathquiz.Components.CustomKeyboard
import com.productivityservicehub.emathquiz.DataClass.levels
import com.productivityservicehub.emathquiz.ui.theme.AccentColor
import com.productivityservicehub.emathquiz.ui.theme.Primary
import com.productivityservicehub.emathquiz.utils.LevelProgressManager


private fun showToast(context: Context ,str:String) {
    Toast.makeText(context, str, Toast.LENGTH_LONG).show()
}

@Composable
fun QuestionScreen(levelNumber: Int, navController: NavController) {
    val level = levels[levelNumber - 1]
    val context = LocalContext.current
    var answer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Level ${level.number}", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = level.questionImageRes),
                contentDescription = "Question Image",
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = answer,
                onValueChange = { answer = it },
                label = { Text("Answer") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (answer == level.correctAnswer) {
                        LevelProgressManager.setHighestLevelCompleted(context, level.number)
                        navController.navigate("correct_answer/${level.number}")
                    } else {
                        showToast(context,"Wrong Answer")
                        // Optionally, show a message to the user that the answer is incorrect
                    }
                }
            ) {
                Text("Submit Answer")
            }
        }

        CustomKeyboard(onKeyClick = { key ->
            when (key) {
                "X" -> answer = ""
                "ENTER" -> {
                    if (answer == level.correctAnswer) {
                        navController.navigate("correct_answer/${level.number}")
                    } else {
                        showToast(context,"Wrong Answer")
                        // Optionally, show a message to the user that the answer is incorrect
                    }
                }
                else -> answer += key
            }
        })
    }
}
