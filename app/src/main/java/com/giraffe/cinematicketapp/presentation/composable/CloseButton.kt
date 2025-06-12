package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.giraffe.cinematicketapp.R
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    size: Dp = 45.dp,
) {
    Box(
        modifier = modifier.background(color = white.copy(alpha = .2f), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .padding(size * .4f)
                .border(
                    width = 1.dp, color = white, shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .size(size)
                    .padding(size * .2f),
                painter = painterResource(R.drawable.ic_close),
                contentDescription = "close",
                colorFilter = ColorFilter.tint(white)
            )
        }

    }
}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        CloseButton()
    }
}