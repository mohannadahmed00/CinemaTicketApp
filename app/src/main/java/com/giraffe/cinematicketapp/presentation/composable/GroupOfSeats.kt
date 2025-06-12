package com.giraffe.cinematicketapp.presentation.composable

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.giraffe.cinematicketapp.presentation.model.SeatUiModel
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.darkGray

@Composable
fun GroupOfSeats(
    modifier: Modifier = Modifier,
    seats: List<SeatUiModel> = emptyList(),
    selectSeat: (SeatUiModel) -> Unit = {},
    selectedSeats: SnapshotStateList<SeatUiModel> = mutableStateListOf()
) {
    Box(modifier = modifier.clip(RectangleShape)) {
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
                repeat(seats.size) {
                    Seat(
                        modifier = Modifier
                            .width(50.dp)
                            .height(40.dp)
                            .clickable {
                                Log.d("messi", "GroupOfSeats: ${seats[it].col} - ${seats[it].row}")
                                //selectSeat(seats[it])
                            },
                        state = seats[it],
                        isSelected = seats[it] in selectedSeats
                    )
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