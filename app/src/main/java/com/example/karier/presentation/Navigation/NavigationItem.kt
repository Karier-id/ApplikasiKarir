package com.example.karier.presentation.Navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.karier.Screen

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen = Screen.Register
)