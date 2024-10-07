package com.umbr.jetpackcomposeandroid16.presentation.screens.coffee_list

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.umbr.jetpackcomposeandroid16.R
import com.umbr.jetpackcomposeandroid16.data.models.CoffeeModel

@Composable
// Первый экран
fun CoffeeListScreen(viewModel: CoffeeListViewModel) {
    val coffeeList = viewModel.coffeeListState.collectAsState()
    val scrollableState = ScrollableState { it }

    LazyColumn {} // прокручиваемый список

    LazyVerticalGrid(
        columns = GridCells.Fixed(2) // колчичество ячеек
    ) {} // прокручиваемый список с разделениями

    LazyVerticalStaggeredGrid( // прокручиваемый список с разными размероми элементов
        modifier = Modifier
            .fillMaxSize()
            .scrollable(scrollableState, Orientation.Vertical),
        contentPadding = PaddingValues(10.dp),
        columns = StaggeredGridCells.Fixed(3)
    ) {
        item {
            BaseImage(
                modifier = Modifier.size(
                    width = 100.dp,
                    height = 80.dp
                ), image = coffeeList.value[0].image
            )
        }
        item {
            BaseImage(
                modifier = Modifier.size(
                    width = 100.dp,
                    height = 120.dp
                ), image = coffeeList.value[0].image
            )
        }
        item {
            BaseImage(
                modifier = Modifier.size(
                    width = 100.dp,
                    height = 100.dp
                ), image = coffeeList.value[0].image
            )
        }
        item {
            BaseImage(
                modifier = Modifier.size(
                    width = 100.dp,
                    height = 140.dp
                ), image = coffeeList.value[0].image
            )
        }
        item {
            BaseImage(
                modifier = Modifier.size(
                    width = 100.dp,
                    height = 60.dp
                ), image = coffeeList.value[0].image
            )
        }
        item {
            BaseImage(
                modifier = Modifier.size(
                    width = 100.dp,
                    height = 100.dp
                ), image = coffeeList.value[0].image
            )
        }

//        item {
//            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
//                items(10) {
//                    BaseImage(modifier = Modifier.size(100.dp), image = coffeeList.value[0].image)
//                }
//            }
//        }

//        items(coffeeList.value) { coffeeModel ->
//            CoffeeItem(coffeeModel = coffeeModel)
//        }
    }
}

@Composable
fun CoffeeItem(modifier: Modifier = Modifier, coffeeModel: CoffeeModel) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.DarkGray, RoundedCornerShape(20.dp))
    ) {
        BaseImage(
            modifier = Modifier.size(100.dp),
            image = coffeeModel.image
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
            text = coffeeModel.name,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Composable
fun BaseImage(
    modifier: Modifier = Modifier,
    image: String,
    contentDescription: String = ""
) {
    AsyncImage(
        modifier = modifier.clip(RoundedCornerShape(20.dp)),
        model = image,
        contentDescription = contentDescription,
        placeholder = painterResource(id = R.drawable.placeholder),
        contentScale = ContentScale.Crop
    )
}

@Composable
@Preview
fun CoffeeItemPreview() {
    CoffeeItem(coffeeModel = CoffeeModel("Capuchino", ""))
}

