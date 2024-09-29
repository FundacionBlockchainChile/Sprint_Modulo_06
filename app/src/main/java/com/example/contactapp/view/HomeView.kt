package com.example.contactapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.contactapp.viewModel.ContactViewModel
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, viewModel: ContactViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Contactos") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("AddContactView")
            }) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        }
    ) {
        ContentHomeView(it, viewModel)
    }
}

@Composable
fun ContentHomeView(pad: PaddingValues, viewModel: ContactViewModel) {
    val contacts by viewModel.contactList.collectAsState()

    Column(
        modifier = Modifier
            .padding(pad)
    ) {
        LazyColumn {
            items(contacts) { contact ->
                Text(text = "${contact.name} - ${contact.phone}")
            }
        }
    }
}
