package com.productivityservicehub.emathquiz.Navigation

import LevelCompletedScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.productivityservicehub.emathquiz.Screens.CorrectAnswerScreen
import com.productivityservicehub.emathquiz.Screens.DashBoardScreen
import com.productivityservicehub.emathquiz.Screens.LevelScreen
import com.productivityservicehub.emathquiz.Screens.QuestionScreen

@Composable
fun NavHost(){

    var navController= rememberNavController()

    androidx.navigation.compose.NavHost(navController, startDestination = "dashboard_screen") {
        composable("dashboard_screen"){ DashBoardScreen(navController) }
        composable("level_screen") { LevelScreen(navController) }
        composable("level_detail/{levelNumber}") { backStackEntry ->
            val levelNumber = backStackEntry.arguments?.getString("levelNumber")?.toInt() ?: 0
            QuestionScreen(levelNumber, navController)
        }
        composable("correct_answer/{levelNumber}") { backStackEntry ->
            val levelNumber = backStackEntry.arguments?.getString("levelNumber")?.toInt() ?: 0
            CorrectAnswerScreen(levelNumber, navController)
        }
        composable("level_completed") { LevelCompletedScreen(navController) }
    }

}