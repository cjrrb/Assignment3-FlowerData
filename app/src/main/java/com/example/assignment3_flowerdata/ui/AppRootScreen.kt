package com.example.assignment3_flowerdata.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppRootScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "flower-list"){
        composable(route = "flower-list") {
            FlowerListScreen(
                onItemclick = { navController.navigate("flower-details/$it") }
            )
        }
        composable(
            route = "flower-details/{flowerId}",
            arguments = listOf(navArgument("flowerId") { type = NavType.StringType })
        ){
            FlowerDetailsScreen(
                onNavigateBack = { navController.navigateUp() }
            )
        }
    }
}