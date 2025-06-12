package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.giraffe.cinematicketapp.presentation.ui.theme.gray
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun TagItem(modifier: Modifier = Modifier, tag: String) {
    Box(
        modifier = modifier
            .border(1.dp, color = gray.copy(.2f), shape = RoundedCornerShape(30.dp))
            .background(white, shape = RoundedCornerShape(30.dp))
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
            text = tag
        )
    }
}