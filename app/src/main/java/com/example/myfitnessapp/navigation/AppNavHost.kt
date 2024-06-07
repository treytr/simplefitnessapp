

package com.example.myfitnessapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfitnessapp.navigation.Routes.ROUTE_HOME
import com.example.myfitnessapp.navigation.Routes.ROUTE_LOGIN
import com.example.myfitnessapp.navigation.Routes.ROUTE_PERSONAL_INFO
import com.example.myfitnessapp.navigation.Routes.ROUTE_PROGRAM
import com.example.myfitnessapp.ui.theme.screens.login.LoginScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_LOGIN) {
    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(
                navController
            )
        }
        composable(ROUTE_HOME) {
            LoginScreen(
                navController
            )
        }
        composable(ROUTE_PERSONAL_INFO) {
            LoginScreen(
                navController
            )
        }
        composable(ROUTE_PROGRAM) {
            LoginScreen(
                navController
            )
        }


    }




    }
