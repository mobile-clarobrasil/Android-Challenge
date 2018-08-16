package com.example.henry.forkit.presentation

import com.example.henry.forkit.api.ENDPOINT
import com.example.henry.forkit.domain.Meal
import com.example.henry.forkit.interfaces.AsyncSearchMeal

class MealPresenter(private val mealController: MealController){

    fun searchMeals(search: String){
        val data= AsyncSearchMeal().execute(ENDPOINT.SEARCH_URL, search).get()
        if(!data.isEmpty()){
            mealController.onSuccess(data)
        }else{
            mealController.onError("no-result")
        }
    }

}