package com.example.karier.presentation.Dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.decode.ImageSource
import com.example.karier.R
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.PrimaryBlue200
import com.example.karier.ui.theme.PrimaryBlue300
import com.example.karier.ui.theme.TextPrimary
import com.example.karier.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderDashboard(
    modifier: Modifier = Modifier,
    title: String,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
            .background(PrimaryBlue300)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 10.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Black),
                color = TextPrimary,
                modifier = Modifier.align(Alignment.Center)
            )
            IconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.filledIconButtonColors(PrimaryBlue200),
                modifier = Modifier
                    .size(36.dp)
                    .align(Alignment.CenterEnd)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_notifications),
                    contentDescription = "Notification",
                    tint = TextPrimary,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
        SearchBar()
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@ExperimentalMaterial3Api
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember { mutableListOf("ndlddpd", "snsl") }
    SearchBar(
        query = text,
        onQueryChange = {
            text = it
        },
        onSearch = {
            items.add(text)
            active = false
        },
        active = active,
        onActiveChange = {
            active = it
        },
        placeholder = {
            Text(
                text = "Cari",
                style = MaterialTheme.typography.labelLarge.copy(color = TextSecondary),
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Cari Icon",
                tint = TextSecondary
            )
        },
        trailingIcon = {
            if (active) {
                Icon(modifier = Modifier.clickable {
                    if (text.isNotEmpty()) {
                        text = ""
                    } else {
                        active = false
                    }
                }, imageVector = Icons.Default.Close, contentDescription = "Close Icon")

            }
        },
        modifier = modifier
            .clip(RoundedCornerShape(20.dp)),
        colors = SearchBarDefaults.colors(PrimaryBlue200),
    ) {
        items.forEach {
            Row(modifier = Modifier.padding(14.dp)) {
                Icon(
                    modifier = Modifier.padding(end = 10.dp),
                    contentDescription = "history icon",
                    imageVector = Icons.Default.History
                )
                Text(text = it)
            }
        }
    }

}

@Preview
@Composable
private fun TopBarPreview() {
    KarierTheme {
        HeaderDashboard(title = "Daftar")
    }
}