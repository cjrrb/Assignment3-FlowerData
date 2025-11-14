package com.example.assignment3.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.assignment3.ui.flowerdetails.FlowerDetailsScreen
import com.example.assignment3.ui.flowerlist.FlowerListScreen

@Composable
fun AppRootScreen(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "flower-list"
    ){
        composable(route = "flower-list") {
            FlowerListScreen(
                onItemClick = { id -> navController.navigate("flower-details/$id") }
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