package com.giraffe.cinematicketapp.presentation.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(state = state, actions = viewModel)
}

@Composable
fun HomeContent(
    state: HomeScreenState,
    actions: HomeScreenActions
) {
}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        HomeScreen()
    }
}