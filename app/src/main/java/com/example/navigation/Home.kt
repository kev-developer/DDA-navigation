package com.example.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onBack: () -> Unit) {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("Volver")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                TextButton(
                    onClick = { selectedTab = 0 },
                    modifier = Modifier.weight(1f),
                    colors = if (selectedTab == 0) ButtonDefaults.filledTonalButtonColors() else ButtonDefaults.textButtonColors()
                ) {
                    Text("Hola Mundo")
                }
                TextButton(
                    onClick = { selectedTab = 1 },
                    modifier = Modifier.weight(1f),
                    colors = if (selectedTab == 1) ButtonDefaults.filledTonalButtonColors() else ButtonDefaults.textButtonColors()
                ) {
                    Text("Tabs")
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            if (selectedTab == 0) {
                Text("Hola Mundo", style = MaterialTheme.typography.headlineMedium)
            } else {
                Text("Funcionamiento tabs", style = MaterialTheme.typography.headlineMedium)
            }
        }
    }
}