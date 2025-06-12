package com.giraffe.cinematicketapp.di

import com.giraffe.cinematicketapp.presentation.screen.home.HomeViewModel
import com.giraffe.cinematicketapp.presentation.screen.seats.SeatsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel() }
    viewModel { SeatsViewModel() }
}