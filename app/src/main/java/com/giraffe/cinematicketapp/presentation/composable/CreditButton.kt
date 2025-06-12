package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.giraffe.cinematicketapp.presentation.ui.theme.orange
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun CreditButton(
    modifier: Modifier = Modifier,
    text: String = "Booking",
    iconSize: Dp = 28.dp,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors().copy(containerColor = orange),
        onClick = {}
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier.size(iconSize),
                painter = painterResource(R.drawable.ic_credit_card),
                contentDescription = "credit card",
                colorFilter = ColorFilter.tint(white)
            )
            Text(text = text, fontSize = 18.sp)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        CreditButton()
    }
}