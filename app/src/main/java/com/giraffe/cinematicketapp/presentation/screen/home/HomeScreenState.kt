package com.giraffe.cinematicketapp.presentation.screen.home

import com.giraffe.cinematicketapp.R
import com.giraffe.cinematicketapp.presentation.model.MovieUiModel

data class HomeScreenState(
    val selectedMovieType: MovieType = MovieType.NOW_SHOWING,
    val selectedMovie: MovieUiModel = MovieUiModel(),
    val movies: List<MovieUiModel> = List(10) {
        if (it % 2 == 0) {
            MovieUiModel()
        } else {
            MovieUiModel(
                cover = R.drawable.film_cover_2,
                title = "The SpongeBob Movie: Sponge Out of Water",
                description = "When a diabolical pirate above the sea steals the secret Krabby Patty formula, SpongeBob and his friends team up in order to get it back.",
                durationInMinutes = 92,
                tags = listOf("Adventure", "Animation"),
                rateOfIMDb = 6.0,
                rateOfRottenTomatoes = 80,
                rateOfIGN = 6.8,
            )
        }

    },
    val selectedTab: Tab = Tab.HOME,
)

enum class MovieType(val text: String) {
    NOW_SHOWING("Now Showing"),
    COMING_SOON("Coming Soon"),
}

enum class Tab(val icon: Int, val notificationCount: Int = 0) {
    HOME(R.drawable.ic_movie),
    SEARCH(R.drawable.ic_search),
    RESERVATIONS(R.drawable.ic_ticket, notificationCount = 3),
    PROFILE(R.drawable.ic_profile),
}
