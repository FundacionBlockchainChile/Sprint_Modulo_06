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
fun EditContactView(navController: NavController, viewModel: ContactViewModel, contactId: Long) {
    val contact = viewModel.contactList.collectAsState().value.find { it.id == contactId }

    var name by remember { mutableStateOf(contact?.name ?: "") }
    var phone by remember { mutableStateOf(contact?.phone ?: "") }
    var email by remember { mutableStateOf(contact?.email ?: "") }
    var profileImage by remember { mutableStateOf(contact?.profileImage ?: "") }
    var dateOfBirth by remember { mutableStateOf(contact?.dateOfBirth ?: "") }

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
            label = { Text(text = "Imagen de Perfil (URL)") },
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
                val updatedContact = ContactModel(
                    id = contactId,
                    name = name,
                    phone = phone,
                    email = email,
                    profileImage = profileImage,
                    dateOfBirth = dateOfBirth
                )
                viewModel.updateContact(updatedContact)
                navController.popBackStack() // Volver a la vista principal
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Guardar Cambios")
        }
    }
}
