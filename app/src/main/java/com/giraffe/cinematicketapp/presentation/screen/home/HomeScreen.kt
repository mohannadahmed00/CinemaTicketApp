package com.giraffe.cinematicketapp.presentation.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.RenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giraffe.cinematicketapp.R
import com.giraffe.cinematicketapp.presentation.composable.BottomNavigationBar
import com.giraffe.cinematicketapp.presentation.composable.Duration
import com.giraffe.cinematicketapp.presentation.composable.OrangeButton
import com.giraffe.cinematicketapp.presentation.composable.TabIcon
import com.giraffe.cinematicketapp.presentation.ui.theme.black
import com.giraffe.cinematicketapp.presentation.ui.theme.gray
import com.giraffe.cinematicketapp.presentation.ui.theme.orange
import com.giraffe.cinematicketapp.presentation.ui.theme.trans
import com.giraffe.cinematicketapp.presentation.ui.theme.white

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(state = state)
}

@Composable
fun HomeContent(
    state: HomeScreenState = HomeScreenState(),
    //actions: HomeScreenActions
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .blur(50.dp)
                .background(white)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f),
                painter = painterResource(R.drawable.film_cover),
                contentDescription = "blur film cover",
                contentScale = ContentScale.Crop
            )
        }
        Column {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 32.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    MovieType.entries.forEach { movieType ->
                        OrangeButton(
                            isSelected = movieType == state.selectedMovieType,
                            text = movieType.text,
                            fontSize = 14.sp
                        )
                    }

                }
                Box(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()
                        .weight(4f)
                        .background(orange)
                )
                Duration(durationInMinutes = state.selectedMovie.durationInMinutes)
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = state.selectedMovie.title,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
                LazyRow (
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ){
                    items(state.selectedMovie.tags) { tag->
                        OrangeButton(
                            text = tag,
                            fontSize = 12.sp,
                            fontColor = black
                        )
                    }
                }

            }
            BottomNavigationBar(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                selectedTab = state.selectedTab,
                iconSize = 35.dp
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        HomeContent()
    }
}