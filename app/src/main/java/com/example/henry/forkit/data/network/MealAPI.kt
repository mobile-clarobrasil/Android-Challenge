package com.example.henry.forkit.data.network

import com.example.henry.forkit.data.entity.MealResponse
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealAPI{
    private val mealService: MealService

    init {
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
                .baseUrl(ENDPOINT.SEARCH_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        mealService = retrofit.create<MealService>(MealService::class.java)
    }

    fun searchMeal(search: String): Call<MealResponse> = mealService.searchMeal(search)
}