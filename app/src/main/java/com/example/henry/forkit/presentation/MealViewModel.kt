package com.example.henry.forkit.presentation

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.data.repository.MealRepository

class MealViewModel(val app: Application): AndroidViewModel(app){

    private var mealRepository: MealRepository? = MealRepository(app)

    private var mealFavoriteList: LiveData<MutableList<Meal>>?
    private var mealSearchList: MutableLiveData<MutableList<Meal>> = MutableLiveData()

    init { mealFavoriteList = mealRepository?.allFavorites() }

    fun allFavorites(): LiveData<MutableList<Meal>>? = mealFavoriteList
    fun checkIfExist(idMeal: String) = mealRepository?.checkExist(idMeal)
    fun save(meal: Meal){
        mealRepository?.save(meal)
    }
    fun delete(meal: Meal){
        mealRepository?.delete(meal)
    }

    /* SEARCH LIST */
    fun setSearchList(data: MutableList<Meal>){
        mealSearchList.postValue(data)
    }
    fun getSearchedList() = mealSearchList
}