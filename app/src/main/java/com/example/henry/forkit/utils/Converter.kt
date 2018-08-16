package com.example.henry.forkit.utils

import com.example.henry.forkit.domain.Meal
import org.json.JSONObject

class Converter{

    fun jsonToMeal(json: JSONObject): Meal{
        val meal = Meal()
        meal.idMeal = json.getString("idMeal")
        meal.strMeal = json.getString("strMeal")
        meal.strCategory = json.getString("strCategory")
        meal.strArea = json.getString("strArea")
        meal.strMealThumb = json.getString("strMealThumb")
        meal.strInstructions = json.getString("strInstructions")
        meal.strIngredient1 = json.getString("strIngredient1")
        meal.strIngredient2 = json.getString("strIngredient2")
        meal.strIngredient3 = json.getString("strIngredient3")
        meal.strIngredient4 = json.getString("strIngredient4")
        meal.strIngredient5 = json.getString("strIngredient5")
        meal.strIngredient6 = json.getString("strIngredient6")
        meal.strIngredient7 = json.getString("strIngredient7")
        meal.strIngredient8 = json.getString("strIngredient8")
        meal.strIngredient9 = json.getString("strIngredient9")
        meal.strIngredient10 = json.getString("strIngredient10")
        meal.strIngredient11 = json.getString("strIngredient11")
        meal.strIngredient12 = json.getString("strIngredient12")
        meal.strIngredient13 = json.getString("strIngredient13")
        meal.strIngredient14 = json.getString("strIngredient14")
        meal.strIngredient15 = json.getString("strIngredient15")
        meal.strIngredient16 = json.getString("strIngredient16")
        meal.strIngredient17 = json.getString("strIngredient17")
        meal.strIngredient18 = json.getString("strIngredient18")
        meal.strIngredient19 = json.getString("strIngredient19")
        meal.strIngredient20 = json.getString("strIngredient20")
        meal.strMeasure1 = json.getString("strMeasure1")
        meal.strMeasure2 = json.getString("strMeasure2")
        meal.strMeasure3 = json.getString("strMeasure3")
        meal.strMeasure4 = json.getString("strMeasure4")
        meal.strMeasure5 = json.getString("strMeasure5")
        meal.strMeasure6 = json.getString("strMeasure6")
        meal.strMeasure7 = json.getString("strMeasure7")
        meal.strMeasure8 = json.getString("strMeasure8")
        meal.strMeasure9 = json.getString("strMeasure9")
        meal.strMeasure10 = json.getString("strMeasure10")
        meal.strMeasure11 = json.getString("strMeasure11")
        meal.strMeasure12 = json.getString("strMeasure12")
        meal.strMeasure13 = json.getString("strMeasure13")
        meal.strMeasure14 = json.getString("strMeasure14")
        meal.strMeasure15 = json.getString("strMeasure15")
        meal.strMeasure16 = json.getString("strMeasure16")
        meal.strMeasure17 = json.getString("strMeasure17")
        meal.strMeasure18 = json.getString("strMeasure18")
        meal.strMeasure19 = json.getString("strMeasure19")
        meal.strMeasure20 = json.getString("strMeasure20")
        return meal
    }
}