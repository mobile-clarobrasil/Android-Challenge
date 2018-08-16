package com.example.henry.forkit.presentation

import com.example.henry.forkit.domain.Meal

interface MealController{
    fun onSuccess(data: MutableList<Meal>)
    fun onError(message: String)
}