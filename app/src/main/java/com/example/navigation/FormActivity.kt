package com.example.navigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigation.ui.theme.NavigationTheme

class FormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                FormScreen(
                    onBack = { finish() },
                    onNavigateToGreeting = { name ->
                        val intent = Intent(this, GreetingActivity::class.java).apply {
                            putExtra("USER_NAME", name)
                        }
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(onBack: () -> Unit, onNavigateToGreeting: (String) -> Unit) {
    var name by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Formulario") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("ingresa nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { if (name.isNotBlank()) onNavigateToGreeting(name) },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Enviar")
            }
        }
    }
}
