package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.black
import com.giraffe.cinematicketapp.presentation.ui.theme.gray
import com.giraffe.cinematicketapp.presentation.ui.theme.lightBrown
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun TimeCard(
    modifier: Modifier = Modifier,
    time: String = "12:30",
    isSelected: Boolean = false,
    fontSize: TextUnit = 20.sp
) {
    Box(
        modifier = modifier
            .background(
                color = if (isSelected) lightBrown else white,
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) lightBrown else gray.copy(alpha = .5f),
                shape = RoundedCornerShape(50.dp)
            )
            .padding(vertical = 8.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = time, style = TextStyle(
                fontSize = fontSize,
                color = if (isSelected) white else black,
                fontWeight = FontWeight.W500
            )
        )
    }
}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        TimeCard()
    }
}