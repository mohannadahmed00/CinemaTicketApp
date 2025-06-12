package com.giraffe.cinematicketapp.presentation.screen.home

import com.giraffe.cinematicketapp.R
import com.giraffe.cinematicketapp.presentation.model.MovieUIModel

data class HomeScreenState(
    val selectedMovieType: MovieType = MovieType.NOW_SHOWING,
    val movies: List<MovieUIModel> = List(5) { MovieUIModel() },
    val selectedTab: Tab = Tab.HOME,
)

enum class MovieType {
    NOW_SHOWING,
    COMING_SOON,
}

enum class Tab(val icon: Int) {
    HOME(R.drawable.ic_movie),
    SEARCH(R.drawable.ic_search),
    RESERVATIONS(R.drawable.ic_ticket),
    PROFILE(R.drawable.ic_profile),
}
