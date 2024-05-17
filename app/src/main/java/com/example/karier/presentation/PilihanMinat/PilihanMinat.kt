package com.example.karier.presentation.PilihanMinat

import android.content.ClipData.Item
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.R
import com.example.karier.presentation.PilihanMinat.component.ItemPilihanMinat
import com.example.karier.ui.theme.KarierTheme

@Composable
fun PilihanMinatScreen(
    modifier: Modifier = Modifier
) {
    Scaffold { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            Text(
                text = "Minat apa yang Anda cari?",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Text(
                text = "Pilih 2-4 kategori minat dan mulai cari lowongan untuk anda",
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Normal)
            )
            Card() {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(horizontal = 22.dp, vertical = 52.dp)
                ) {
                    ItemPilihanMinat(
                        icon = ImageVector.vectorResource(id = R.drawable.icon_designer),
                        text = "Designer"
                    )
                    ItemPilihanMinat(
                        icon = ImageVector.vectorResource(id = R.drawable.icon_marketing),
                        text = "Marketing"
                    )
                    ItemPilihanMinat(
                        icon = ImageVector.vectorResource(id = R.drawable.icon_content_marketing),
                        text = "Content Marketing"
                    )
                    ItemPilihanMinat(
                        icon = ImageVector.vectorResource(id = R.drawable.icon_designer2),
                        text = "Designer"
                    )
                    ItemPilihanMinat(
                        icon = ImageVector.vectorResource(id = R.drawable.icon_designer3),
                        text = "Designer"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KarierTheme {
        PilihanMinatScreen()
    }
}