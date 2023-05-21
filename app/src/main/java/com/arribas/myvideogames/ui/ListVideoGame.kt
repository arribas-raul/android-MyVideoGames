package com.arribas.myvideogames.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arribas.myvideogames.R
import com.arribas.myvideogames.data.LocalGameDataProvider
import com.arribas.myvideogames.data.VideoConsole
import com.arribas.myvideogames.data.Videogame
import com.arribas.myvideogames.ui.theme.MyVideoGamesTheme

@Composable
fun ListVideoGame(
    modifier: Modifier = Modifier,
    list: List<Videogame>,
    onItemClick: (Videogame) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(list, key = { videogame -> videogame.id }) { videogame ->
            ItemVideoGame(
                videogame = videogame,
                onItemClick = { onItemClick(videogame)})
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemVideoGame(
    videogame: Videogame,
    onItemClick: (Videogame) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(),

        modifier = Modifier
            .padding(1.dp)
            .height(dimensionResource(R.dimen.card_image_height))
            .border(width = 0.2.dp, color = Color.Gray, shape = RoundedCornerShape(5.dp))
            .background(color = Color.White),

        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(videogame) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
                .background(color = Color.White)
        ) {
            DetailItemVideoGame(
                videogame = videogame,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
        }
    }
}

@Composable
private fun DetailItemVideoGame(
    videogame: Videogame,
    modifier: Modifier = Modifier) {

    Row {
        Box(
            modifier = modifier.weight(1.5f)

        ) {
            Image(
                painter = painterResource(videogame.img),
                contentDescription = null,
                alignment = Alignment.CenterStart,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.card_image_height))
            )
        }

        Column(
            modifier = modifier
                .weight(5f)
        ) {
            Text(
                text = stringResource(videogame.name),
                textAlign = TextAlign.Left,
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 10.dp)
            )

            Divider(
                color = Color.DarkGray,
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 10.dp, top = 2.dp, bottom = 2.dp, end = 10.dp),
            )

            Text(
                text = stringResource(videogame.description),
                modifier = Modifier.padding(start = 10.dp, top = 2.dp, bottom = 2.dp, end = 14.dp),
                fontSize = 12.sp,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                maxLines = 5
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight()
        ) {

            Text(
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color.Blue,
                            radius = 40f
                        )
                    },
                text = stringResource(videogame.score),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListVideoGamnePreview() {
    MyVideoGamesTheme {
        ListVideoGame(
            list = LocalGameDataProvider.getGameData(VideoConsole.PS5),
            onItemClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    MyVideoGamesTheme {
        ItemVideoGame(
            videogame = LocalGameDataProvider.defaultGame,
            onItemClick = {}
        )
    }
}

