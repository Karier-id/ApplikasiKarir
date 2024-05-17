package com.example.karier

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.karier.presentation.LoginScreen

@Composable
fun KarierApp(modifier: Modifier = Modifier) {
    Scaffold { paddingValues ->
        LoginScreen(modifier = Modifier.padding(paddingValues))
    }
}