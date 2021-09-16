package com.simpledeeds.cachingexample.di

import android.content.Context
import androidx.room.Room
import com.simpledeeds.cachingexample.data.local.RestaurantDatabase
import com.simpledeeds.cachingexample.data.remote.RestaurantApi
import com.simpledeeds.cachingexample.repositories.RestaurantRepository
import com.simpledeeds.cachingexample.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRestaurantApi(): RestaurantApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestaurantApi::class.java)

    @Provides
    @Singleton
    fun providesRestaurantDatabase(@ApplicationContext context: Context): RestaurantDatabase =
        Room.databaseBuilder(context, RestaurantDatabase::class.java, Constants.DATABASE_NAME)
            .build()
}