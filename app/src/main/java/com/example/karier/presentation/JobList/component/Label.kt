package com.example.karier.presentation.JobList.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.R
import com.example.karier.domain.fakeData.FakeDataJobVariant
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.SecondaryBackground
import com.example.karier.ui.theme.TextPrimary

@Preview(showBackground = true)
@Composable
fun LabelRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        LabelText(label = "", isIcon = true, selected = true)
        val items = FakeDataJobVariant.dataFake
        items.forEach() {
            LabelText(label = it.jobVariant, isIcon = false)
        }
    }
}

//@Preview
//@Composable
//fun LabelRow() {
//    KarierTheme {
//        LabelRow()
//    }
//}

@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean = false,
    isIcon: Boolean = false
) {
    Button(
        onClick = { /*TODO*/ },
        colors = if (selected) ButtonDefaults.buttonColors(TextPrimary) else ButtonDefaults.buttonColors(
            SecondaryBackground
        ),
        border = if (selected) BorderStroke(1.dp, SecondaryBackground) else BorderStroke(
            1.dp,
            TextPrimary
        ),
        modifier = modifier,
        elevation = ButtonDefaults.buttonElevation(
            disabledElevation = 1.dp,
            defaultElevation = 1.dp,
            focusedElevation = 1.dp,
            hoveredElevation = 1.dp,
            pressedElevation = 1.dp
        )
    ) {
        if (isIcon) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
                contentDescription = "Icon"
            )
        } else {
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                color = TextPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LabelPreview() {
    KarierTheme {
        LabelText(label = "Teknik")
    }
}