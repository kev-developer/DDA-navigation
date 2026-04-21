package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.navigation.ui.theme.NavigationTheme

class GreetingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val name = intent.getStringExtra("USER_NAME") ?: ""
        setContent {
            NavigationTheme {
                GreetingScreen(name = name, onBack = { finish() })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingScreen(name: String, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Saludo") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("Hola $name", style = MaterialTheme.typography.headlineMedium)
        }
    }
}
