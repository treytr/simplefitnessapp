package com.example.myfitnessapp.ui.theme.screens.personalinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class PersonalScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PersonalScreenContent(navController)
        }
    }
}

@Composable
fun PersonalScreenContent(navController: NavController) {
    var showAgeDialog by remember { mutableStateOf(false) }
    var showWeightDialog by remember { mutableStateOf(false) }
    var showExperienceDialog by remember { mutableStateOf(false) }

    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

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
            Button(onClick = { showAgeDialog = true }) {
                Text(text = "State your age", color = Color.White, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { showWeightDialog = true }) {
                Text(text = "State your weight", color = Color.White, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { showExperienceDialog = true }) {
                Text(text = "State your experience", color = Color.White, fontSize = 18.sp)
            }

            if (age.isNotEmpty()) {
                Text(text = "Age: $age", color = Color.White, fontSize = 16.sp)
            }
            if (weight.isNotEmpty()) {
                Text(text = "Weight: $weight", color = Color.White, fontSize = 16.sp)
            }
            if (experience.isNotEmpty()) {
                Text(text = "Experience: $experience", color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("program") }) {
                Text(text = "Go to Programs", color = Color.White, fontSize = 18.sp)
            }
        }
    }

    if (showAgeDialog) {
        InputDialog(
            title = "Enter your age",
            onDismiss = { showAgeDialog = false },
            onConfirm = { input ->
                age = input
                showAgeDialog = false
            }
        )
    }

    if (showWeightDialog) {
        InputDialog(
            title = "Enter your weight",
            onDismiss = { showWeightDialog = false },
            onConfirm = { input ->
                weight = input
                showWeightDialog = false
            }
        )
    }

    if (showExperienceDialog) {
        ExperienceDialog(
            onDismiss = { showExperienceDialog = false },
            onConfirm = { input ->
                experience = input
                showExperienceDialog = false
            }
        )
    }
}

@Composable
fun InputDialog(
    title: String,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = title) },
        text = {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.background(Color.White)
            )
        },
        confirmButton = {
            Button(
                onClick = { onConfirm(text) }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun ExperienceDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    val experiences = listOf("Beginner", "Intermediate", "Pro")
    var selectedExperience by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Select your experience") },
        text = {
            Column {
                experiences.forEach { experience ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = (selectedExperience == experience),
                            onClick = { selectedExperience = experience }
                        )
                        Text(text = experience)
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = { onConfirm(selectedExperience) }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    )
}