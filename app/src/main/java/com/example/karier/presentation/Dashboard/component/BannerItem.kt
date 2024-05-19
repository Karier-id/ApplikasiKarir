package com.example.karier.presentation.Dashboard.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.karier.presentation.Dashboard.fakeData.FakeDataBanner
import com.example.karier.ui.theme.KarierTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerItem(
    modifier: Modifier = Modifier,
    title: String,
    url: String,
    pagerState: PagerState
) {
    AsyncImage(
        model = title,
        contentDescription = url,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .height(138.dp)
            .background(Color.Gray)
            .fillMaxWidth()
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselBanner(modifier: Modifier = Modifier) {
    val pagerState =
        rememberPagerState(initialPage = 0, pageCount = { FakeDataBanner.dataFake.size })
    val animationScope = rememberCoroutineScope()
    HorizontalPager(
        state = pagerState,
        userScrollEnabled = true,
    ) { page ->
        Box(modifier = Modifier.fillMaxSize().padding(5.dp)) {
            val info = FakeDataBanner.dataFake.getOrNull(page)
            info?.let {
                BannerItem(
                    title = info.title,
                    url = info.url,
                    pagerState = pagerState,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarouselBannerPreview() {
    KarierTheme {
        CarouselBanner()
    }
}