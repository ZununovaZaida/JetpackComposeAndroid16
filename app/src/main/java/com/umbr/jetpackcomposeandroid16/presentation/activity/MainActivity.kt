package com.umbr.jetpackcomposeandroid16.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import com.umbr.jetpackcomposeandroid16.presentation.screens.ScreensName
import com.umbr.jetpackcomposeandroid16.presentation.screens.SecondScreen
import com.umbr.jetpackcomposeandroid16.presentation.screens.coffee_list.CoffeeListScreen
import com.umbr.jetpackcomposeandroid16.presentation.screens.coffee_list.CoffeeListViewModel

class MainActivity : ComponentActivity() {

    private val coffeeListViewModel by lazy {
        ViewModelProvider(this)[CoffeeListViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var visibleScreen by remember {
                mutableStateOf(ScreensName.COFFEE_LIST_SCREEN)
            }

            var nameForFirst by remember {
                mutableStateOf("")
            }
            when (visibleScreen) {
                ScreensName.COFFEE_LIST_SCREEN -> {
                    CoffeeListScreen(viewModel = coffeeListViewModel)
                }

                ScreensName.SECOND_SCREEN -> {
                    SecondScreen { name ->
                        nameForFirst = name
                        visibleScreen = ScreensName.COFFEE_LIST_SCREEN
                    }
                }
            }
        }
    }
}