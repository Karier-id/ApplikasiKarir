package com.example.karier.domain.fakeData

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.karier.R
import com.example.karier.domain.model.Notification

object FakeDataNotification {
    val dataFake = listOf(
        Notification(
            id = "1",
            title = "Update Keaman",
            date = "16, Mei 2024",
            time = "20.00",
            icon = R.drawable.ic_update_security
        ),
        Notification(
            id = "2",
            title = "Update Profil",
            date = "16, Mei 2024",
            time = "20.00",
            icon = R.drawable.ic_update_profile
        ),
        Notification(
            id = "3",
            title = "Lamaran Telah Dikirim!",
            date = "16, Mei 2024",
            time = "20.00",
            icon = R.drawable.ic_turned_in
        )
    )
}