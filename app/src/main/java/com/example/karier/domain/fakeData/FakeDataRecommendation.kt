package com.example.karier.domain.fakeData

import com.example.karier.domain.model.ModelRecomendation

object FakeDataRecommendation {
    val dataFake = listOf(
        ModelRecomendation(
            id = "1",
            title = "Marketing Manager",
            imageContent = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4wfV5JYFU7G9zbETgUqVQpEOSVfjmAVucXCEns1QDgg&s",
            company = "PT. Sangkala Jaya Abadi",
            location = "Samarinda Seberang, Samarinda Kalimantan Timur",
            label = "Full Time",
            variant = listOf(FakeDataJobVariant.mappedDataJobVariant.getValue("Teknik"))
        ),
        ModelRecomendation(
            id = "2",
            title = "Marketing",
            imageContent = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4wfV5JYFU7G9zbETgUqVQpEOSVfjmAVucXCEns1QDgg&s",
            company = "PT. Permata Indo Sejahtera",
            location = "Bandung, Kota Bandung, Jawa Barat",
            label = "Full Time",
            variant = listOf(FakeDataJobVariant.mappedDataJobVariant.getValue("Marketing"))

        ),
        ModelRecomendation(
            id = "3",
            title = "Manager Marketing",
            imageContent = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4wfV5JYFU7G9zbETgUqVQpEOSVfjmAVucXCEns1QDgg&s",
            company = "PT. Global Service Indo",
            location = "Padang, Kota Padang Sumatera Barat",
            label = "Full Time",
            variant = listOf(FakeDataJobVariant.mappedDataJobVariant.getValue("Marketing"))
        ),
        ModelRecomendation(
            id = "4",
            title = "Manager Marketing",
            imageContent = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4wfV5JYFU7G9zbETgUqVQpEOSVfjmAVucXCEns1QDgg&s",
            company = "PT. BFI Finance Indonesia TBK",
            location = "Tegal, Kota Tegal, Jawa Tengah",
            label = "Full Time",
            variant = listOf(FakeDataJobVariant.mappedDataJobVariant.getValue("Marketing"))
        ),
        ModelRecomendation(
            id = "5",
            title = "Kreative",
            imageContent = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4wfV5JYFU7G9zbETgUqVQpEOSVfjmAVucXCEns1QDgg&s",
            company = "PT. Permata Indo Sejahtera",
            location = "Bandung, Kota Bandung, Jawa Barat",
            label = "Full Time",
            variant = listOf(FakeDataJobVariant.mappedDataJobVariant.getValue("Kreative"))
        )
    )
}

