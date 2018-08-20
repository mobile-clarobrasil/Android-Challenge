package com.example.henry.forkit.presentation

import android.content.Context
import android.util.Log
import com.example.henry.forkit.data.entity.MealResponse
import com.example.henry.forkit.data.repository.MealRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealPresenter(val context: Context?, private val retrieveDataController: RetrieveDataController? = null,
                    private val insertDataController: InsertDataController? = null,
                    private val checkExistDataContoller: CheckExistDataController? = null){

    private var mealRepository: MealRepository = MealRepository(context!!)


    fun searchMeals(search: String){
        mealRepository.searchMeals(search).enqueue(object : Callback<MealResponse> {
            override fun onResponse(call: Call<MealResponse>?, response: Response<MealResponse>?) {
                if(response?.isSuccessful != null){
                    val data = response.body()?.meals
                    if (data != null) {
                        retrieveDataController?.onSuccessRetrieveData(data)
                    }else{
                        retrieveDataController?.onErrorRetrieveData("no-results")
                    }
                }
            }
            override fun onFailure(call: Call<MealResponse>?, t: Throwable?) {}
        })
    }


}