package com.simpledeeds.cachingexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Restaurant(

    val name: String,
    val type: String,
    val logo: String,
    val address: String,
    @PrimaryKey val id: Int
)
