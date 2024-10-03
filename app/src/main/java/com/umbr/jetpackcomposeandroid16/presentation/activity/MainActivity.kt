package com.umbr.jetpackcomposeandroid16.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.umbr.jetpackcomposeandroid16.presentation.screens.FirstScreen
import com.umbr.jetpackcomposeandroid16.presentation.screens.ScreensName
import com.umbr.jetpackcomposeandroid16.presentation.screens.SecondScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var visibleScreen by remember {
                mutableStateOf(ScreensName.FIRST_SCREEN)
            }

            var nameForFirst by remember {
                mutableStateOf("")
            }
            when (visibleScreen) {
                ScreensName.FIRST_SCREEN -> {
                    FirstScreen(nameForFirst) {
                        visibleScreen = ScreensName.SECOND_SCREEN
                    }
                }

                ScreensName.SECOND_SCREEN -> {
                    SecondScreen { name ->
                        nameForFirst = name
                        visibleScreen = ScreensName.FIRST_SCREEN
                    }
                }
            }
        }
    }
}