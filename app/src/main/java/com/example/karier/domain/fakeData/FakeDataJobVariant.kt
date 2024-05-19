package com.example.karier.domain.fakeData

import com.example.karier.domain.model.JobVariant

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

