package com.example.contactapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contactapp.view.AddPhotoView
import com.example.contactapp.view.HomeView
import com.example.contactapp.viewModel.ImagesViewModel

@Composable
fun NavManager(viewModel: ImagesViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController, viewModel)
        }
        composable("AddPhotoView") {
            AddPhotoView(viewModel)
        }
    }
}