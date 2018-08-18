package com.example.henry.forkit.presentation

import android.content.Context
import android.util.Log
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.data.repository.MealRepository

class MealPresenter(context: Context?, private val retrieveDataController: RetrieveDataController? = null,
                    private val insertDataController: InsertDataController? = null,
                    private val checkExistDataContoller: CheckExistDataController? = null){

    private var mealRepository: MealRepository = MealRepository(context)

    fun searchMeals(search: String){
        val response = mealRepository.searchMeals(search).execute()
        if(response.isSuccessful){
            val data = response.body()?.meals
            if (data != null) {
                retrieveDataController?.onSuccessRetrieveData(data)
            }else{
                retrieveDataController?.onErrorRetrieveData("no-results")
            }
        }
    }

    fun saveMeal(meal: Meal){
        val data = mealRepository.save(meal)
        if(data != 0L){
            insertDataController?.onSuccessSavedData(data)
        }else{
            insertDataController?.onErrorSavedData("error")
        }
    }

    fun getMeals(){
        val data = mealRepository.getMeals()
        if(!data.isEmpty()){
            retrieveDataController?.onSuccessRetrieveData(data)
        }else{
            retrieveDataController?.onErrorRetrieveData("no-results")
        }
    }

    fun delete(meal: Meal) = mealRepository.deleteMeal(meal)

    fun checkExist(idMeal: String){
        if(mealRepository.checkExist(idMeal) == 1){
            checkExistDataContoller?.onSuccessExistData()
        }else{
            checkExistDataContoller?.onErrorExistData()
        }
    }

}