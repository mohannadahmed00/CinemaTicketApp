package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.black
import com.giraffe.cinematicketapp.presentation.ui.theme.darkGray
import com.giraffe.cinematicketapp.presentation.ui.theme.gray
import com.giraffe.cinematicketapp.presentation.ui.theme.lightBrown
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun DateCard(
    modifier: Modifier = Modifier,
    dayNumber: Int = 16,
    dayName: String = "Sat",
    isSelected: Boolean = true
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .background(
                    color = if (isSelected) lightBrown else white,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 1.dp,
                    color = if (isSelected) lightBrown else gray.copy(alpha = .5f),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = dayNumber.toString(), style = TextStyle(
                    fontSize = 24.sp,
                    color = if (isSelected) white else black,
                    fontWeight = FontWeight.W500
                )
            )
            Text(
                text = dayName, style = TextStyle(
                    fontSize = 10.sp,
                    color = if (isSelected) white.copy(.5f) else darkGray,
                    fontWeight = FontWeight.W400
                )
            )
        }
    }

}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        DateCard()
    }
}