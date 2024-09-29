package com.example.contactapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contactapp.view.HomeView
import com.example.contactapp.view.AddContactView
import com.example.contactapp.viewModel.ContactViewModel

@Composable
fun NavManager(viewModel: ContactViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController, viewModel)
        }
        composable("AddContactView") {
            AddContactView(navController, viewModel)
        }
    }
}