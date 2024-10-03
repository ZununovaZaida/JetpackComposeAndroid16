package com.umbr.jetpackcomposeandroid16.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.umbr.jetpackcomposeandroid16.R
import kotlinx.coroutines.delay

@Composable
fun SecondScreen(navigationFirstScreen: (name: String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AsyncImage(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(200.dp)
                .clip(shape = CircleShape)
                .border(width = 3.dp, shape = CircleShape, color = Color.Black),
            contentScale = ContentScale.Crop,
            model = "https://images.wallpapersden.com/image/ws-monkey-luffy-4k-one-piece-2024-art_92971.jpg",
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(
                R.string.anime_person
            )
        )

        Button(onClick = {navigationFirstScreen("SecondScreen")}) {
            Text(text = "Navigate to First screen")
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen {

    }
}