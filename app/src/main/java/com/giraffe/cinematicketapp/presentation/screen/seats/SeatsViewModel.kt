package com.giraffe.cinematicketapp.presentation.screen.seats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giraffe.cinematicketapp.presentation.model.SeatUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SeatsViewModel : ViewModel(), SeatsScreenActions {
    private val _state = MutableStateFlow(SeatsScreenState())
    val state = _state.asStateFlow()
    override fun selectSeat(seatUiModel: SeatUiModel) {
        viewModelScope.launch {
            _state.value.selectedSeats.add(seatUiModel)
        }
    }
}