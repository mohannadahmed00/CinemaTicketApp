package com.giraffe.cinematicketapp.presentation.screen.home

import com.giraffe.cinematicketapp.presentation.model.MovieUiModel

interface HomeScreenActions {
    fun selectTab(tab: Tab)
    fun selectMovie(movie: MovieUiModel)
    fun selectMovieType(movieType: MovieType)
}