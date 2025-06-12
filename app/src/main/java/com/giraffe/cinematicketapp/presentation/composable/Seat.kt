package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.giraffe.cinematicketapp.presentation.model.SeatUiModel
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.darkGray
import com.giraffe.cinematicketapp.presentation.ui.theme.orange
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun Seat(
    modifier: Modifier = Modifier,
    state: SeatUiModel = SeatUiModel(),
    isSelected: Boolean = false,
) {
    val backgroundColor = remember(state.isAvailable) {
        if (state.isAvailable) {
            if (isSelected) orange else white
        } else {
            darkGray
        }
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(.8f)
                .background(color = backgroundColor, shape = RoundedCornerShape(1.dp))
        )
        Column(
            modifier = modifier
                .padding(horizontal = 1.dp)
                .fillMaxHeight()
                .weight(2.5f),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.6f)
                    .background(color = backgroundColor, shape = RoundedCornerShape(1.dp))
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = backgroundColor, shape = RoundedCornerShape(1.dp))
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(.8f)
                .background(color = backgroundColor, shape = RoundedCornerShape(1.dp))
        )
    }
}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        Seat()
    }
}