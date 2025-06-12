package com.giraffe.cinematicketapp.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giraffe.cinematicketapp.presentation.model.MovieUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(), HomeScreenActions {
    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()
    override fun selectTab(tab: Tab) {
        viewModelScope.launch {
            _state.update { it.copy(selectedTab = tab) }
        }
    }

    override fun selectMovie(movie: MovieUiModel) {
        viewModelScope.launch {
            _state.update { it.copy(selectedMovie = movie) }
        }
    }

    override fun selectMovieType(movieType: MovieType) {
        viewModelScope.launch {
            _state.update { it.copy(selectedMovieType = movieType) }
        }
    }
}