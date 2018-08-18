package com.example.henry.forkit.data.network

import com.example.henry.forkit.data.entity.MealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService{

    @GET("?")
    fun searchMeal(@Query("s") search: String): Call<MealResponse>

}