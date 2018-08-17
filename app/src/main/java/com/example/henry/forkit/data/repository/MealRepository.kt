package com.example.henry.forkit.data.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.henry.forkit.api.ENDPOINT
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.data.local.DatabaseHelper
import com.example.henry.forkit.interfaces.AsyncSearchMeal

class MealRepository(val context: Context?){

    private var db: DatabaseHelper = DatabaseHelper(context)

    fun searchMeals(search: String): MutableList<Meal> = AsyncSearchMeal().execute(ENDPOINT.SEARCH_URL, search).get()

    fun save(meal: Meal): Long = db.insert(meal)
    fun getMeal(id: String): Meal = db.getMeal(id)
    fun getMeals() = db.getAllMeals()
    fun deleteMeal(meal: Meal) = db.deleteMeal(meal)
    fun checkExist(idMeal: String): Int = db.checkExist(idMeal)
}