package com.giraffe.cinematicketapp.presentation.screen.home

import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giraffe.cinematicketapp.presentation.composable.BottomNavigationBar
import com.giraffe.cinematicketapp.presentation.composable.Duration
import com.giraffe.cinematicketapp.presentation.composable.OrangeButton
import com.giraffe.cinematicketapp.presentation.composable.TagItem
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.white
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(state, viewModel)
}

@Composable
fun HomeContent(
    state: HomeScreenState = HomeScreenState(),
    actions: HomeScreenActions
) {
    val pagerState = rememberPagerState { state.movies.size }
    LaunchedEffect(pagerState.currentPage) {
        actions.selectMovie(state.movies[pagerState.currentPage])
    }
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
                painter = painterResource(state.selectedMovie.cover),
                contentDescription = "blur film cover",
                contentScale = ContentScale.Crop
            )
        }
        Column {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
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
                        ) {
                            actions.selectMovieType(movieType)
                        }
                    }

                }
                HorizontalPager(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()
                        .weight(4f),
                    contentPadding = PaddingValues(horizontal = 60.dp),
                    state = pagerState,
                ) { page ->
                    val scale = animateFloatAsState(
                        targetValue = if (page == pagerState.currentPage) 1.0f else 0.8f,
                        label = ""
                    ).value
                    Image(
                        modifier = Modifier
                            .width(300.dp)
                            .height(400.dp)
                            .scale(scale)
                            .clip(RoundedCornerShape(16.dp)),
                        painter = painterResource(state.movies[page].cover),
                        contentDescription = "cover",
                        contentScale = ContentScale.Crop
                    )
                }
                Duration(durationInMinutes = state.selectedMovie.durationInMinutes)
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = state.selectedMovie.title,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
                LazyRow(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(state.selectedMovie.tags) { tag ->
                        TagItem(tag = tag)
                    }
                }

            }
            BottomNavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                selectedTab = state.selectedTab,
                iconSize = 35.dp,
                selectTab = actions::selectTab
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        HomeScreen()
    }
}