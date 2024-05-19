package com.example.karier.domain.fakeData

data class FakeBanner(
    val title: String,
    val url: String,
)

object FakeDataBanner{
    val dataFake = listOf(
        FakeBanner(
            title = "Tips Untuk Anda",
            url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4wfV5JYFU7G9zbETgUqVQpEOSVfjmAVucXCEns1QDgg&s",
        ),
        FakeBanner(
            title = "Tips Untuk Anda",
            url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4wfV5JYFU7G9zbETgUqVQpEOSVfjmAVucXCEns1QDgg&s",
        ),
        FakeBanner(
            title = "Tips Untuk Anda",
            url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4wfV5JYFU7G9zbETgUqVQpEOSVfjmAVucXCEns1QDgg&s",
        ),

    )
}