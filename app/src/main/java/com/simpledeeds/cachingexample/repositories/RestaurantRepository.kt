package com.simpledeeds.cachingexample.repositories

import androidx.room.withTransaction
import com.simpledeeds.cachingexample.data.local.RestaurantDatabase
import com.simpledeeds.cachingexample.data.remote.RestaurantApi
import com.simpledeeds.cachingexample.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
) {
    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() =
        networkBoundResource(
            query = {
                restaurantDao.getAllRestaurants()
            },
            fetch = {
                delay(1000)
                api.getRestaurants()
            },
            saveFetchResult = { restaurants ->
                db.withTransaction {
                    restaurantDao.deleteAllRestaurant()
                    restaurantDao.insertRestaurant(restaurants)
                }
            }
        )

}