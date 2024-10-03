package com.umbr.jetpackcomposeandroid16.presentation.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umbr.jetpackcomposeandroid16.R

@Composable
fun FirstScreen(data: String, navigateSecondScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(200.dp),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                focusedElevation = 20.dp
            ),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.anime_person),
                contentDescription = stringResource(
                    R.string.anime_person
                )
            )
        }

        Log.e("firstScreen", "FirstScreen: $data", )

        Button(onClick = { navigateSecondScreen() }) {
            Text(text = "Navigate to Second screen")
        }
    }
}

@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen("") {

    }
}