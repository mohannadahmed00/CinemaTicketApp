package com.giraffe.cinematicketapp.presentation.model

import com.giraffe.cinematicketapp.R

data class MovieUIModel(
    val cover: Int = R.drawable.film_cover,
    val title: String = "The SpongeBob Movie: Sponge on the Run",
    val description: String = "After SpongeBob's beloved pet snail Gary is snail-napped, he and Patrick embark on an epic adventure to the Lost City of Atlantic City to bring Gary home.",
    val durationInMinutes: Int = 143,
    val tags: List<String> = listOf("Fantasy", "Sea Adventure", "Comedy"),
    val rateOfIMDb: Double = 5.9,
    val rateOfRottenTomatoes: Int = 66,
    val rateOfIGN: Int = 7,
    val actorsImages: List<Int> = List(15) { R.drawable.actor_image }
)