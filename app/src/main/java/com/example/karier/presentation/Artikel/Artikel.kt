package com.example.karier.presentation.Artikel

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.karier.R
import com.example.karier.presentation.component.TopBar
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.Outline
import com.example.karier.ui.theme.PrimaryBackground
import com.example.karier.ui.theme.PrimaryBlue200
import com.example.karier.ui.theme.PrimaryBlue300
import com.example.karier.ui.theme.SecondaryBackground
import com.example.karier.ui.theme.TextPrimary
import com.example.karier.ui.theme.TextSecondary

@Composable
fun ArtikelScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit
) {

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopBar(title = "", navigateBack = navigateBack, backButton = true)
//            IconButton(content = ImageVector.vectorResource(id = R.drawable.icon_share), contentDescription = "Share Artikel")
        }
    ) { paddingValues ->
        Column(modifier = modifier.verticalScroll(scrollState).padding(paddingValues)) {
            AsyncImage(
                model = "https://blueraycargo.id/wp-content/uploads/2023/04/rahasia-sukses-orang-china.jpeg",
                contentDescription = "Artikel Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .size(360.dp, 202.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(PrimaryBlue200)
            )
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 22.dp),
                text = "Cara Cari Kerja Yang sesuai Dengan Minat Anda",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                color = TextPrimary
            )
            Box(modifier = Modifier.padding(start = 22.dp, top = 8.dp)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        6.dp,
//                        Alignment.CenterHorizontally
                    ),
//                    verticalAlignment = Alignment.Top,
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_lihat),
                        contentDescription = "Lihat",
                        tint = Outline
                    )
                    Text(
                        text = "750.0K",
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium),
                        color = TextPrimary
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_like),
                        contentDescription = "Menyukai",
                        tint = Outline
                    )
                    Text(
                        text = "800.0K",
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium),
                        color = TextPrimary
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_komentar),
                        contentDescription = "Komentar",
                        tint = Outline
                    )
                    Text(
                        text = "525.0K",
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium),
                        color = TextPrimary
                    )
                }
            }
            Box(modifier = Modifier.padding(top = 20.dp)) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.image_cnn),
                        contentDescription = "CNN",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.padding(start = 22.dp).size(35.dp, 35.dp)
                    )
                    Text(
                        text = "CNN Indonesia",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold )
                    )
                }
                Column {
                    Text(
                        text = "5 hari yang lalu", style = MaterialTheme.typography.labelSmall.copy(
                            color = Outline
                        )
                    )
                }
            }
            Text(
                text = "Pengusaha nyentrik asal Indonesia Bob Sadino pernah berkata bahwa pekerjaan yang enak adalah hobi yang dibayar. Bekerja pada hal atau bidang yang disukai tentu akan membawa kepuasan bagi diri sendiri maupun bagi perusahaan.\n\n" +
                        "Carilah lowongan pekerjaan yang memang sesuai dengan minat atau hobi agar bila diterima tidak ada beban saat menjalankannya.\n\n" +
                        "Minat atau hobi yang sesuai dengan pekerjaan yang akan digeluti biasanya akan membantu pekerja supaya lebih produktif dalam menghasilkan sesuatu. Tak hanya itu, bisa juga kualitas yang dihasilkan lebih baik dibanding yang pekerjaannya tidak sesuai minat.\n\n" +
                        "Namun tak ada salahnya mempertimbangkan opsi lain yang mendekati dengan bidang kesukaanmu, atau industri lainnya yang punya peluang karier baik. Jangan terlalu strict atau kaku berpatok pada satu pekerjaan. Dengan begitu akan memperluas peluang dan kesemapatanmu diterima bekerja.",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(22.dp)
            )
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
            ) {
                Text(
                    text = "Komentar",
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KarierTheme {
        ArtikelScreen {}
    }
}