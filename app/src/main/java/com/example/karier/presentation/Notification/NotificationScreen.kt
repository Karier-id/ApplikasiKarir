package com.example.karier.presentation.Notification

import android.app.Notification
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.karier.domain.fakeData.FakeDataNotification
import com.example.karier.presentation.JobList.component.LabelRow
import com.example.karier.presentation.Notification.component.ItemNotification
import com.example.karier.presentation.Notification.component.NavTabRow
import com.example.karier.presentation.component.TopBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(
    navigateBack:() -> Unit
) {
    val notificationTitle = listOf("Umum", "Lamaran")
    val tabPagerState = rememberPagerState { notificationTitle.size }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBar(title = "Notifikasi", navigateBack = {navigateBack()}, backButton = true, isFilled = true)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues).padding(12.dp)
        ) {
            item {
                NavTabRow(
                    tabTitles = notificationTitle,
                    pagerState = tabPagerState,
                    onChangeTabIndex = { newIndex: Int ->
                        coroutineScope.launch {
                            tabPagerState.animateScrollToPage(newIndex)
                        }
                    }
                )
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                HorizontalPager(state = tabPagerState) { tabIndex ->
                    when (notificationTitle[tabIndex]) {
                        "Umum" -> {
                            val items = FakeDataNotification.dataFake
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                items.forEach { item ->
                                    ItemNotification(
                                        title = item.title,
                                        date = item.date,
                                        time = item.time,
                                        icon = item.icon
                                    )
                                }
                            }
                        }
                        "Lamaran" -> {
                            Text(text = "Test")
                        }
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NotificationScreenPreview() {
    NotificationScreen(navigateBack = {})
}