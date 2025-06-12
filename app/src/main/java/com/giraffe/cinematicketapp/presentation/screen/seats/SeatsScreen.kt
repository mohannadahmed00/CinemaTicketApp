package com.giraffe.cinematicketapp.presentation.screen.seats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giraffe.cinematicketapp.R
import com.giraffe.cinematicketapp.presentation.composable.CloseButton
import com.giraffe.cinematicketapp.presentation.composable.CreditButton
import com.giraffe.cinematicketapp.presentation.composable.DateCard
import com.giraffe.cinematicketapp.presentation.composable.GroupOfSeats
import com.giraffe.cinematicketapp.presentation.composable.Label
import com.giraffe.cinematicketapp.presentation.composable.TimeCard
import com.giraffe.cinematicketapp.presentation.model.SeatUiModel
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.black
import com.giraffe.cinematicketapp.presentation.ui.theme.darkGray
import com.giraffe.cinematicketapp.presentation.ui.theme.gray
import com.giraffe.cinematicketapp.presentation.ui.theme.orange
import com.giraffe.cinematicketapp.presentation.ui.theme.white
import org.koin.androidx.compose.koinViewModel


@Composable
fun SeatsScreen(viewModel: SeatsViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()
    SeatsContent(state, viewModel)
}

@Composable
fun SeatsContent(state: SeatsScreenState = SeatsScreenState(), actions: SeatsScreenActions) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
    ) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth()
                .fillMaxHeight(.72f)
                .background(black)
        ) {
            CloseButton(modifier = Modifier.padding(16.dp), size = 18.dp)
            Image(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .graphicsLayer {
                        scaleX = .8f
                        rotationX = -15f
                        cameraDistance = 1 * density
                    },
                painter = painterResource(R.drawable.film_cover),
                contentDescription = "cover",
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                repeat(state.numberOfColumns) { col ->
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        repeat(state.numberOfRows) { row ->
                            GroupOfSeats(
                                modifier = Modifier.graphicsLayer {
                                    val half = state.numberOfColumns / 2
                                    val percentToScreen = 8f
                                    rotationZ = if (col == half) 0f else {
                                        if (col < half) half * percentToScreen else -half * percentToScreen
                                    }
                                },
                                seats = List(state.numOfSeatsInGroup) {
                                    //col = 1
                                    //row = 0
                                    SeatUiModel(col = col + it, row = row + it)
                                },
                                selectSeat = actions::selectSeat,
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Label()
                Label(text = "Taken", color = darkGray)
                Label(text = "Selected", color = orange)
            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f)
                .background(
                    color = white,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyRow(
                modifier = Modifier.padding(vertical = 20.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                items(30) {
                    DateCard(isSelected = it == 3)
                }
            }
            LazyRow(
                modifier = Modifier
                    .padding(vertical = 0.dp)
                    .weight(1f),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                items(30) {
                    TimeCard(
                        isSelected = it == 0,
                        fontSize = 16.sp
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "$100.00",
                        style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.W500)
                    )
                    Text("4 tickets", fontSize = 16.sp, color = gray)
                }
                CreditButton(
                    modifier = Modifier.fillMaxHeight(.5f),
                    text = "Buy tickets"
                )
            }

        }
    }
}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        //SeatsContent()
    }
}