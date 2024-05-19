package com.example.karier.presentation.Dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.presentation.Dashboard.component.CarouselBanner
import com.example.karier.presentation.Dashboard.component.HeaderDashboard
import com.example.karier.presentation.Dashboard.component.ItemRecommendation
import com.example.karier.domain.fakeData.FakeDataRecommendation

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { HeaderDashboard(title = "Karier.id") }) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    text = "Tips untuk anda",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                )
            }
            item { CarouselBanner() }
            item { Spacer(modifier = Modifier.height(1.dp)) }
            item {
                Text(
                    text = "Rekomendasi untuk Anda",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                )
            }
            val items = FakeDataRecommendation.dataFake.take(3)
            items(items = items, key = { it.title }) {
                ItemRecommendation(
                    title = it.title,
                    company = it.company,
                    location = it.location,
                    imageContent = it.imageContent,
                    label = it.imageContent
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen()
}