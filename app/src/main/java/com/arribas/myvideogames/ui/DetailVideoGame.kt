package com.arribas.myvideogames.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import com.arribas.myvideogames.data.Videogame
import com.arribas.myvideogames.ui.theme.MyVideoGamesTheme

@Composable
fun DetailVideoGame(
    videogame: Videogame,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White),

        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = stringResource(videogame.name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 18.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 10.dp)
        )

        Divider(
            color = Color.DarkGray,
            thickness = 0.5.dp,
            modifier = Modifier.padding(start = 10.dp, top = 2.dp, bottom = 20.dp, end = 10.dp))

        Box() {
            Image(
                alignment = Alignment.TopCenter,
                painter = painterResource(videogame.img),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
            )
        }

        Text(
            text = stringResource(videogame.description),
            fontSize = 14.sp,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp, start = 40.dp, end = 40.dp)
        )

        Text(
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(start = 60.dp, bottom = 20.dp)
                .drawBehind {
                    drawCircle(
                        color = Color.Blue,
                        radius = 70f)
                },
            text = stringResource(videogame.score)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListVideoGamePreview() {
    MyVideoGamesTheme {
        DetailVideoGame(LocalGameDataProvider.defaultGame)
    }
}
