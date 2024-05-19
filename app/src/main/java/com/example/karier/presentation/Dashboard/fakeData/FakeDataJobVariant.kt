package com.example.karier.presentation.Dashboard.fakeData

import com.example.karier.presentation.Dashboard.model.JobVariant

object FakeDataJobVariant {
    val dataFake = listOf(
        JobVariant(
            jobVariant = "Teknik"
        ),
        JobVariant(
            jobVariant = "Marketing"
        ),
        JobVariant(
            jobVariant = "Manajemen"
        ),
        JobVariant(
            jobVariant = "Kreative"
        )
    )
    val mappedDataJobVariant = dataFake.associate { it.jobVariant to it }
}

