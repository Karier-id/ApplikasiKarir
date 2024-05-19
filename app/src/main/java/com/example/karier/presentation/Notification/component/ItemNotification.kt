package com.example.karier.presentation.Notification.component

import androidx.compose.foundation.background
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
import com.example.karier.presentation.Dashboard.component.ItemRecommendation
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.PrimaryBlue300
import com.example.karier.ui.theme.SecondaryBackground
import com.example.karier.ui.theme.TextPrimary
import androidx.compose.material3.Icon

@Composable
fun ItemNotification(
    modifier: Modifier = Modifier,
    title: String,
    company: String,
    location: String,
    icon: ImageVector,
    label: String
) {
    ElevatedCard(
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .wrapContentSize()
            .height(120.dp)
            .padding(end = 4.dp)
            .clip(RoundedCornerShape(4.dp)),
        colors = CardDefaults.cardColors(SecondaryBackground)
    ) {
        Column {
            Row(
                modifier = modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon",
                    modifier.padding(start = 8.dp, end = 8.dp),
                    tint = TextPrimary
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
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Text(
                        text = company,
                        style = MaterialTheme.typography.labelSmall
                    )
                    Row(
                        verticalAlignment = Alignment.Top,
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_location),
                            modifier = Modifier.size(15.dp),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = location,
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                        )
                    }
                }
                Card(
                    modifier = modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = CardDefaults.cardColors(PrimaryBlue300.copy(alpha = 0.25f)),
                ) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemNotificationPreview() {
    val title: String = "Marketing Manager"
    val company: String = "PT. Sangkala Jaya Abadi"
    val location: String = "Samarinda Seberang, Samarinda Kalimantan Timur"
    val icon: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_location)
    val label: String = "Full Time"
    KarierTheme {
        ItemNotification(
            modifier = Modifier,
            title = title,
            company = company,
            location = location,
            icon = icon,
            label = label
        )
    }
}