package com.example.contactapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.contactapp.model.ContactModel
import com.example.contactapp.viewModel.ContactViewModel

@Composable
fun AddContactView(navController: NavController, viewModel: ContactViewModel) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var profileImage by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Nombre") },
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text(text = "Teléfono") },
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Correo") },
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            value = profileImage,
            onValueChange = { profileImage = it },
            label = { Text(text = "Imagen de Perfil (Ruta)") },
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            value = dateOfBirth,
            onValueChange = { dateOfBirth = it },
            label = { Text(text = "Fecha de Nacimiento") },
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = {
                val newContact = ContactModel(
                    name = name,
                    phone = phone,
                    email = email,
                    profileImage = profileImage,
                    dateOfBirth = dateOfBirth
                )
                viewModel.insertContact(newContact)
                navController.popBackStack() // Volver a la vista anterior
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Guardar Contacto")
        }
    }
}
