package com.giraffe.cinematicketapp.presentation.screen.details

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giraffe.cinematicketapp.R
import com.giraffe.cinematicketapp.presentation.composable.CloseButton
import com.giraffe.cinematicketapp.presentation.composable.CreditButton
import com.giraffe.cinematicketapp.presentation.composable.Duration
import com.giraffe.cinematicketapp.presentation.composable.TabIcon
import com.giraffe.cinematicketapp.presentation.composable.TagItem
import com.giraffe.cinematicketapp.presentation.model.MovieUiModel
import com.giraffe.cinematicketapp.presentation.screen.home.HomeViewModel
import com.giraffe.cinematicketapp.presentation.ui.theme.CinemaTicketAppTheme
import com.giraffe.cinematicketapp.presentation.ui.theme.gray
import com.giraffe.cinematicketapp.presentation.ui.theme.orange
import com.giraffe.cinematicketapp.presentation.ui.theme.white
import org.koin.androidx.compose.koinViewModel


@Composable
fun DetailsScreen(viewModel: HomeViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()
    DetailsContent(movie = state.selectedMovie)
}

@Composable
fun DetailsContent(movie: MovieUiModel = MovieUiModel()) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f)
                .background(orange)
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(movie.cover),
                contentDescription = "movie cover",
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 32.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CloseButton(size = 18.dp)
                Box(
                    modifier = Modifier.background(
                        color = white.copy(.3f),
                        shape = RoundedCornerShape(30.dp)
                    )
                ) {
                    Duration(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        durationInMinutes = movie.durationInMinutes,
                        fontColor = white
                    )

                }
            }

            TabIcon(
                modifier = Modifier.align(Alignment.Center),
                icon = R.drawable.ic_play,
                isSelected = true
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.52f)
                .background(
                    color = white,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row {
                        Text(text = "${movie.rateOfIMDb}", fontWeight = FontWeight.Bold)
                        Text(text = "/10", color = gray)
                    }
                    Text(text = "IMDb", color = gray, fontSize = 14.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "${movie.rateOfRottenTomatoes}%", fontWeight = FontWeight.Bold)
                    Text(text = "Rotten Tomatoes", color = gray, fontSize = 14.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row {
                        Text(text = "${movie.rateOfIGN}", fontWeight = FontWeight.Bold)
                        Text(text = "/10", color = gray)
                    }
                    Text(text = "IGN", color = gray, fontSize = 14.sp)
                }
            }
            Text(
                modifier = Modifier.padding(horizontal = 32.dp),
                text = movie.title,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            LazyRow(
                modifier = Modifier.padding(vertical = 12.dp),
                contentPadding = PaddingValues(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(movie.tags) { tag ->
                    TagItem(tag = tag)
                }
            }
            LazyRow(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                contentPadding = PaddingValues(horizontal = 24.dp)
            ) {
                items(movie.actorsImages) { tag ->
                    Image(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape),
                        painter = painterResource(tag),
                        contentDescription = "actor",
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Text(
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
                text = movie.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            CreditButton()
        }
    }

}

@Preview
@Composable
private fun Preview() {
    CinemaTicketAppTheme {
        DetailsContent()
    }
}