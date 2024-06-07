package com.example.myfitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import com.example.myfitnessapp.ui.theme.screens.home.HomeScreen
import com.example.myfitnessapp.ui.theme.screens.login.LoginScreen

import com.example.myfitnessapp.ui.theme.screens.personalinformation.PersonalScreenContent
import com.example.myfitnessapp.ui.theme.screens.workoutprograms.ExerciseListScreen
import com.example.myfitnessapp.ui.theme.screens.workoutprograms.Program
import com.example.myfitnessapp.ui.theme.screens.workoutprograms.getAthleticExercises
import com.example.myfitnessapp.ui.theme.screens.workoutprograms.getFitExercises
import com.example.myfitnessapp.ui.theme.screens.workoutprograms.getMuscularExercises

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }


        composable("personal") {
            PersonalScreenContent(navController)
        }
        composable("program") {
            Program(navController)
        }
        composable("fit") {
            ExerciseListScreen("Fit", getFitExercises())
        }
        composable("muscular") {
            ExerciseListScreen("Muscular", getMuscularExercises())
        }
        composable("athletic") {
            ExerciseListScreen("Athletic", getAthleticExercises())
        }
    }
}

