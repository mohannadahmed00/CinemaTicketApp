package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.darkGray
import com.giraffe.cinematicketapp.presentation.ui.theme.orange
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun Seat(
    modifier: Modifier = Modifier,
    isAvailable: Boolean = true,
    isSelected: Boolean = false,
) {
    val backgroundColor = remember(isAvailable) {
        if (isAvailable) {
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
                .width(5.dp)
                .height(12.dp)
                .background(color = backgroundColor, shape = RoundedCornerShape(1.dp))
        )
        Column(
            modifier = modifier.padding(horizontal = 1.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(12.dp)
                    .height(10.dp)
                    .background(color = backgroundColor, shape = RoundedCornerShape(1.dp))
            )
            Box(
                modifier = Modifier
                    .width(12.dp)
                    .height(5.dp)
                    .background(color = backgroundColor, shape = RoundedCornerShape(1.dp))
            )
        }

        Box(
            modifier = Modifier
                .width(5.dp)
                .height(12.dp)
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