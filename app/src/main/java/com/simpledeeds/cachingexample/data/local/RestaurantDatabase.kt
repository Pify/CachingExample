package com.simpledeeds.cachingexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simpledeeds.cachingexample.data.Restaurant

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}