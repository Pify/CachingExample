package com.simpledeeds.cachingexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.simpledeeds.cachingexample.repositories.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()
}