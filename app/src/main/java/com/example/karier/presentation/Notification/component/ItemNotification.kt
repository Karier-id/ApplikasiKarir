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
import androidx.compose.material3.Text
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
import com.example.karier.ui.theme.PrimaryBlue400
import com.example.karier.ui.theme.TextSecondary

@Composable
fun ItemNotification(
    modifier: Modifier = Modifier,
    title: String,
    date: String,
    time: String,
    icon: Int,
    label: String = "Baru"
) {
    ElevatedCard(
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .wrapContentSize()
            .height(90.dp)
            .padding(end = 4.dp)
            .clip(RoundedCornerShape(4.dp)),
        colors = CardDefaults.cardColors(SecondaryBackground)
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Absolute.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = icon),
                    contentDescription = "Icon",
                    modifier
                        .size(30.dp)
                        .fillMaxWidth(),
                    tint = TextPrimary
                )
                Column(
                    modifier = modifier
                        .weight(2f)
                        .fillMaxWidth()
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(3.dp),
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = TextPrimary
                    )
                    Text(
                        text = "$date | $time",
                        style = MaterialTheme.typography.labelSmall.copy(color = TextSecondary)
                    )
                }
                Card(
                    modifier = modifier
                        .clip(RoundedCornerShape(6.dp)),
                    colors = CardDefaults.cardColors(PrimaryBlue400),
                ) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
                        modifier = modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 5.dp, horizontal = 15.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemNotificationPreview() {
    val title: String = "Update Keamanan!"
    val date: String = "16 Mei. 2024"
    val time: String = "20.00"
    val icon: Int =  R.drawable.ic_location
    val label: String = "Baru"
    KarierTheme {
        ItemNotification(
            modifier = Modifier,
            title = title,
            date = date,
            icon = icon,
            time = time,
            label = label
        )
    }
}