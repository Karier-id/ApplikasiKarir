package com.example.karier.presentation.Dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.karier.R
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.PrimaryBlue300
import com.example.karier.ui.theme.SecondaryBackground
import com.example.karier.ui.theme.TextPrimary

@Composable
fun ItemRecommendation(
    modifier: Modifier = Modifier,
    title: String,
    company: String,
    location: String,
    imageContent: String,
    label: String,
    navigateToDetail: () -> Unit
) {
//    val imageContent = "nlksnlasx"
    ElevatedCard(
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .wrapContentSize()
            .height(120.dp)
            .padding(end = 4.dp)
            .clip(RoundedCornerShape(4.dp))
            .clickable { navigateToDetail() },
        colors = CardDefaults.cardColors(SecondaryBackground)
    ) {
        Column {
            Row(
                modifier = modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = imageContent,
                    contentDescription = "Image",
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .wrapContentHeight()
                        .background(Color.Gray)
                        .weight(1f),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = TextPrimary
                    )
                    Text(
                        text = company,
                        style = MaterialTheme.typography.bodySmall,
                        color = TextPrimary
                    )
                    Row(
                        verticalAlignment = Alignment.Top,
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_location),
                            modifier = Modifier.size(15.dp),
                            contentDescription = "",
                            tint = TextPrimary
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = location,
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                            color = TextPrimary
                        )
                    }
                }
                Card(
                    modifier = modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = CardDefaults.cardColors(PrimaryBlue300.copy(alpha = 0.25f)),
                ) {
                    Column(
                        modifier = modifier
                            .padding(5.dp)
                            .align(Alignment.CenterHorizontally),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = ImageVector
                                .vectorResource(id = R.drawable.ic_schedule),
                            modifier = modifier.size(30.dp),
                            contentDescription = "",
                            tint = TextPrimary
                        )
                        Text(
                            text = label,
                            style = MaterialTheme.typography.labelSmall,
                            color = TextPrimary
                        )
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
private fun ItemRecomendationPreview() {
    val title: String = "Marketing Manager"
    val company: String = "PT. Sangkala Jaya Abadi"
    val location: String = "Samarinda Seberang, Samarinda Kalimantan Timur"
    val imageContent: String =
        "https://i.pinimg.com/736x/bc/20/94/bc20948f3bccfd926b41688b38b3d9c9.jpg"
    val label: String = "Full Time"
    KarierTheme {
        ItemRecommendation(
            modifier = Modifier,
            title = title,
            company = company,
            location = location,
            imageContent = imageContent,
            label = label,
            navigateToDetail = {}
        )
    }
}