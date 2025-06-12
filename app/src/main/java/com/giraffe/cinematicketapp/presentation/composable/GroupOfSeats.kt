package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.darkGray

@Composable
fun GroupOfSeats(
    modifier: Modifier = Modifier,
    numberOfSeats: Int = 2
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .offset(y = (-5).dp)
                .border(
                    width = 1.dp,
                    color = darkGray,
                    shape = RoundedCornerShape(5.dp)
                ),
        ) {
            Row(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 4.dp, top = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                repeat(numberOfSeats) {
                    Seat()
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        GroupOfSeats()
    }
}