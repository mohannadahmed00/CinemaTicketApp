package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giraffe.cinematicketapp.R
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.black
import com.giraffe.cinematicketapp.presentation.ui.theme.gray

@Composable
fun Duration(
    modifier: Modifier = Modifier,
    durationInMinutes: Int = 143,
    fontColor: Color = black
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_clock),
            contentDescription = "clock",
            colorFilter = ColorFilter.tint(gray)
        )
        Text(text = "${durationInMinutes / 60}h", color = fontColor, fontSize = 14.sp)
        Text(text = "${durationInMinutes % 60}m", color = fontColor, fontSize = 14.sp)
    }

}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        Duration()
    }
}