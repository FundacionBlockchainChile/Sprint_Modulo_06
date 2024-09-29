package com.example.contactapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.contactapp.navigation.NavManager
import com.example.contactapp.ui.theme.ContactAppTheme
import com.example.contactapp.viewModel.ContactViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val viewModel: ContactViewModel by viewModels()
        setContent {
            ContactAppTheme {
                NavManager(viewModel)
            }
        }
    }
}