package com.example.karier.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Notification (
    val id: String,
    val title: String,
    val date: String,
    val time: String,
    val icon: Int
)
