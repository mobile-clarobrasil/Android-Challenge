package com.example.henry.forkit.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.data.entity.MealResponse
import com.example.henry.forkit.data.local.FavoriteMealsDatabase
import com.example.henry.forkit.data.local.MealDao
import com.example.henry.forkit.data.network.MealAPI
import com.example.henry.forkit.presentation.MealViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository(val context: Context){

    private var mealDao: MealDao?
    private var favoriteMeals: LiveData<MutableList<Meal>>? = MutableLiveData<MutableList<Meal>>()

    init {
        val db = FavoriteMealsDatabase.getInstance(context)
        mealDao = db?.mealDao
        favoriteMeals = mealDao?.all()
    }

    fun searchMeals(search: String) = MealAPI().searchMeal(search)

    fun allFavorites(): LiveData<MutableList<Meal>>? = favoriteMeals

    fun checkExist(idMeal: String) = CheckIfExistAsync(mealDao).execute(idMeal).get()

    fun save(meal: Meal){
        SaveAsync(mealDao).execute(meal)
    }

    fun delete(meal: Meal){
        DeleteAsync(mealDao).execute(meal)
    }

    private class CheckIfExistAsync(private val mealDao: MealDao?): AsyncTask<String, Unit, Meal?>(){
        override fun doInBackground(vararg params: String?): Meal? {
            val idMeal = params[0]
            if(idMeal != null) {
                return mealDao?.checkExist(idMeal)
            }
            return null
        }
    }

    private class SaveAsync(private val mealDao: MealDao?): AsyncTask<Meal, Unit, Unit>(){
        override fun doInBackground(vararg params: Meal?) {
            val meal = params[0]
            if(meal != null) mealDao?.save(meal)
        }
    }

    private class DeleteAsync(private val mealDao: MealDao?): AsyncTask<Meal, Unit, Unit>(){
        override fun doInBackground(vararg params: Meal?) {
            val meal = params[0]
            if(meal != null) mealDao?.delete(meal)
        }
    }

}