package com.example.henry.forkit.utils

import com.example.henry.forkit.domain.Meal
import org.json.JSONObject

class Converter{

    fun jsonToMeal(json: JSONObject): Meal{
        val meal = Meal()
        meal.idMeal = json.get("idMeal").toString()
        meal.strMeal = json.get("strMeal").toString()
        meal.strMealThumb = json.get("strMealThumb").toString()
        return meal
    }
}