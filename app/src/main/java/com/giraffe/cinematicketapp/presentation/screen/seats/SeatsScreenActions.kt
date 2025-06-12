package com.giraffe.cinematicketapp.presentation.screen.seats

import com.giraffe.cinematicketapp.presentation.model.SeatUiModel

interface SeatsScreenActions {
    fun selectSeat(seatUiModel: SeatUiModel)
}