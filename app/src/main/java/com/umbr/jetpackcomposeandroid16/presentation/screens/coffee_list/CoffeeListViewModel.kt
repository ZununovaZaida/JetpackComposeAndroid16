package com.umbr.jetpackcomposeandroid16.presentation.screens.coffee_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umbr.jetpackcomposeandroid16.data.CoffeeData
import com.umbr.jetpackcomposeandroid16.data.models.CoffeeModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CoffeeListViewModel : ViewModel() {

    private val coffeeData = CoffeeData

    private var _coffeeListState = MutableStateFlow<List<CoffeeModel>>(mutableListOf())
    val coffeeListState = _coffeeListState.asStateFlow()

    init {
        getCoffeeList()
    }

    private fun getCoffeeList() {
        _coffeeListState.value = coffeeData.getCoffeeModelList()
    }
}