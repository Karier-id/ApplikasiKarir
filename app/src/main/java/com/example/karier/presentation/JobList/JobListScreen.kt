package com.example.karier.presentation.JobList

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.presentation.Dashboard.component.HeaderDashboard
import com.example.karier.presentation.Dashboard.component.ItemRecommendation
import com.example.karier.domain.fakeData.FakeDataRecommendation
import com.example.karier.presentation.JobList.component.LabelRow

@Composable
fun JobListScreen(modifier: Modifier = Modifier, navigationToNotification:() -> Unit) {
    Scaffold(topBar = {
        HeaderDashboard(title = "Karier.id", navigateToNotification = navigationToNotification)
    }) { paddingValues ->
        LazyColumn(
            Modifier
                .padding(paddingValues)
                .padding(12.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { Spacer(modifier = Modifier.height(1.dp)) }
            item { LabelRow() }
            item { Spacer(modifier = Modifier.height(1.dp)) }
            val items = FakeDataRecommendation.dataFake ?: emptyList()
            Log.d("JobListScreen", "Items count: ${items.size}")
            if (items.isEmpty()) {
                item {
                    Text("No recommendations available")
                }
            } else {
                items(items = items, key = { it.id }) { item -> // Use unique key
                    Box(modifier = Modifier.padding(vertical = 4.dp)) {
                        ItemRecommendation(
                            title = item.title,
                            company = item.company,
                            location = item.location,
                            imageContent = item.imageContent,
                            label = item.label,
                            navigateToDetail = {}
                        )
                    }
                }
            }
            item { Spacer(modifier = Modifier.height(1.dp)) }
        }
    }
}

@Preview
@Composable
private fun JobListScreenPreview() {
    JobListScreen(navigationToNotification = {})
}