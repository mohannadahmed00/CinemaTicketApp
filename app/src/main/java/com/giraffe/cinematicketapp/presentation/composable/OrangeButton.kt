package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giraffe.cinematicketapp.presentation.ui.theme.gray
import com.giraffe.cinematicketapp.presentation.ui.theme.orange
import com.giraffe.cinematicketapp.presentation.ui.theme.trans
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun OrangeButton(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    text: String = "Button",
    fontSize: TextUnit = 5.sp,
    fontColor: Color = white,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = if (isSelected) orange else trans,
        ),
        border = BorderStroke(1.dp, color = gray.copy(alpha = .5f)),
        onClick = onClick
    ) {
        Text(text = text, fontSize = fontSize, color = fontColor)
    }
}