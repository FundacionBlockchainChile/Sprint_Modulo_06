package com.example.contactapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.contactapp.model.ContactModel
import com.example.contactapp.viewModel.ContactViewModel

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
        ContentHomeView(it, viewModel, navController)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel: ContactViewModel, navController: NavController) {
    val contacts by viewModel.contactList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        items(contacts) { contact ->
            ContactCard(contact, viewModel, navController)
        }
    }
}

@Composable
fun ContactCard(contact: ContactModel, viewModel: ContactViewModel, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen de perfil desde la URL
            Image(
                painter = rememberAsyncImagePainter(contact.profileImage),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
            
            // Información del contacto
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(text = "Nombre: ${contact.name}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Teléfono: ${contact.phone}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Correo: ${contact.email}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Fecha de Nacimiento: ${contact.dateOfBirth}", style = MaterialTheme.typography.bodyMedium)
            }
            
            // Botones de Editar y Eliminar
            IconButton(onClick = { 
                // Navegar a la pantalla de edición
                navController.navigate("EditContactView/${contact.id}")
            }) {
                Icon(Icons.Default.Edit, contentDescription = "Editar", tint = Color.Blue)
            }

            IconButton(onClick = { 
                // Eliminar el contacto
                viewModel.deleteContact(contact)
            }) {
                Icon(Icons.Default.Delete, contentDescription = "Eliminar", tint = Color.Red)
            }
        }
    }
}
