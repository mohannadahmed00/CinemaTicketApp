package com.giraffe.cinematicketapp.presentation.screen.home

import com.giraffe.cinematicketapp.R
import com.giraffe.cinematicketapp.presentation.model.MovieUIModel

data class HomeScreenState(
    val selectedMovieType: MovieType = MovieType.NOW_SHOWING,
    val selectedMovie: MovieUIModel = MovieUIModel(),
    val movies: List<MovieUIModel> = List(5) { MovieUIModel() },
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
