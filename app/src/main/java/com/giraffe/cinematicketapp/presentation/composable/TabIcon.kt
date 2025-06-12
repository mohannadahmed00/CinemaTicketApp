package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giraffe.cinematicketapp.R
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.black
import com.giraffe.cinematicketapp.presentation.ui.theme.orange
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun TabIcon(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_movie,
    isSelected: Boolean = false,
    notificationCount: Int = 3,
    iconSize: Dp = 48.dp,
) {
    Box(
        modifier = modifier
            .background(
                color = if (isSelected) orange else white,
                shape = CircleShape
            )
    ) {
        Row(
            modifier = modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(iconSize),
                painter = painterResource(icon),
                contentDescription = "icon",
                colorFilter = ColorFilter.tint(color = if (isSelected) white else black)
            )
            if (!isSelected && notificationCount != 0) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = modifier
                            .size(iconSize * .5f)
                            .background(
                                color = orange,
                                shape = CircleShape
                            ),
                    )
                    Text(
                        text = notificationCount.toString(),
                        color = white,
                        fontSize = 12.sp
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
        TabIcon()
    }
}