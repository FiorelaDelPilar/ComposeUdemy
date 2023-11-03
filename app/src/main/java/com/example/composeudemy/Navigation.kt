package com.example.composeudemy

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeudemy.ui.screen.MasterScreen

sealed class  Screen(val route:String){
    object MasterScreen: Screen(route = "master")
}
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =  Screen.MasterScreen.route){
        composable(Screen.MasterScreen.route){
            MasterScreen(navController)
        }
    }
}