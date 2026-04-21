package com.example.navigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                MainContent(
                    onNavigateToHome = {
                        startActivity(Intent(this, HomeActivity::class.java))
                    },
                    onNavigateToForm = {
                        startActivity(Intent(this, FormActivity::class.java))
                    }
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MainContent(onNavigateToHome: () -> Unit, onNavigateToForm: () -> Unit) {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Pantalla Principal") })
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = onNavigateToHome, modifier = Modifier.padding(8.dp)) {
                    Text("Home")
                }
                Button(onClick = onNavigateToForm, modifier = Modifier.padding(8.dp)) {
                    Text("Form")
                }
            }
        }
    }
}
