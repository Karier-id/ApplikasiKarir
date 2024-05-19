package com.example.karier.presentation.Notification.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.TextPrimary
import com.example.karier.ui.theme.TextSecondary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavTabRow(
    tabTitles: List<String>,
    pagerState: PagerState,
    onChangeTabIndex: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = MaterialTheme.colorScheme.onPrimary,
        indicator = {},
    ) {
        tabTitles.forEachIndexed { index, title ->
            val selected = pagerState.currentPage == index
            Tab(
                selected = selected,
                onClick = { onChangeTabIndex(index) },
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = if (selected) TextPrimary else TextSecondary,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Divider(
                            thickness = if (selected) 2.dp else 1.dp,
                            color = if (selected) TextPrimary else TextSecondary,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

//        tabTitles.forEachIndexed { index, title ->
//            val selected = pagerState.currentPage == index
//            Tab(
//                selected = selected,
//                onClick = { onChangeTabIndex(index) },
//                modifier = Modifier
//                    .padding(8.dp),
//                text = {
//                    Divider(
//                        thickness = if (selected) 2.dp else 1.dp,
//                        color = if (selected) TextPrimary else TextSecondary
//                    )
//                    Text(
//                        text = title,
//                        style = MaterialTheme.typography.titleMedium.copy(
//                            color = if (selected) TextPrimary else TextSecondary,
//                            fontWeight = FontWeight.W500
//                        ),
//                    )
//                },


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
private fun Preview() {
    KarierTheme {
        NavTabRow(tabTitles = listOf("title 1", "title 2"), pagerState = rememberPagerState {
            2
        }, onChangeTabIndex = {})
    }
}