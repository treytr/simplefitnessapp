package com.example.myfitnessapp.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myfitnessapp.navigation.Routes.ROUTE_LOGIN
import com.example.myfitnessapp.navigation.Routes.ROUTE_PERSONAL_INFO
import com.example.myfitnessapp.navigation.Routes.ROUTE_PROGRAM

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context= LocalContext.current
//        var productdata=productviewmodel(navController,context)

        Text(text = "Trevors Fitness App",
            color = Color.Cyan,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_PERSONAL_INFO)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Fill in personal info")
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_PROGRAM)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Choose Program")
        }


    }



}

@Preview
@Composable
fun Homepreview() {
    HomeScreen(rememberNavController())
}