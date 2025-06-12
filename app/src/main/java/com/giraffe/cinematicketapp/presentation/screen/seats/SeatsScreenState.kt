package com.giraffe.cinematicketapp.presentation.screen.seats

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.giraffe.cinematicketapp.presentation.model.SeatUiModel

data class SeatsScreenState(
    val numberOfColumns: Int = 3,
    val numberOfRows: Int = 5,
    val numOfSeatsInGroup: Int = 2,
    val selectedSeats: SnapshotStateList<SeatUiModel> = mutableStateListOf()
)