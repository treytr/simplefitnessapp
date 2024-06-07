package com.example.myfitnessapp.ui.theme.screens.workoutprograms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class ProgramScreen(navController: NavHostController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "program") {
                composable("program") { Program(navController) }
                composable("fit") { ExerciseListScreen("Fit", getFitExercises()) }
                composable("muscular") { ExerciseListScreen("Muscular", getMuscularExercises()) }
                composable("athletic") { ExerciseListScreen("Athletic", getAthleticExercises()) }
            }
        }
    }
}

@Composable
fun Program(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            ProgramButton(navController, "FIT", "fit")
            Spacer(modifier = Modifier.height(16.dp))
            ProgramButton(navController, "MUSCULAR", "muscular")
            Spacer(modifier = Modifier.height(16.dp))
            ProgramButton(navController, "ATHLETIC", "athletic")
        }
    }
}

@Composable
fun ProgramButton(navController: NavController, text: String, route: String) {
    Button(onClick = { navController.navigate(route) }) {
        Text(
            text = text,
            color = Color.Red,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ExerciseListScreen(programName: String, exercises: List<String>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "$programName Program",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            exercises.forEach { exercise ->
                Text(
                    text = exercise,
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

fun getFitExercises(): List<String> {
    return listOf(
        "Monday: Push-ups, Squats",
        "Tuesday: Running",
        "Wednesday: Rest",
        "Thursday: Push-ups, Squats",
        "Friday: Running",
        "Saturday: Rest",
        "Sunday: Yoga"
    )
}

fun getMuscularExercises(): List<String> {
    return listOf(
        "Monday: Push-ups, Squats, Deadlifts",
        "Tuesday: Running, Pull-ups",
        "Wednesday: Rest",
        "Thursday: Push-ups, Squats, Deadlifts",
        "Friday: Running, Pull-ups",
        "Saturday: Rest",
        "Sunday: Yoga, Planks"
    )
}

fun getAthleticExercises(): List<String> {
    return listOf(
        "Monday: Push-ups, Squats, Deadlifts, Bench Press",
        "Tuesday: Running, Pull-ups, HIIT",
        "Wednesday: Rest",
        "Thursday: Push-ups, Squats, Deadlifts, Bench Press",
        "Friday: Running, Pull-ups, HIIT",
        "Saturday: Rest",
        "Sunday: Yoga, Planks, Sprints"
    )
}
