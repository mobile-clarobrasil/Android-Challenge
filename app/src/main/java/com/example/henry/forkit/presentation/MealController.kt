package com.example.henry.forkit.presentation

import com.example.henry.forkit.data.entity.Meal

interface RetrieveDataController{
    fun onSuccessRetrieveData(data: MutableList<Meal>)
    fun onErrorRetrieveData(message: String)
}

interface InsertDataController{
    fun onSuccessSavedData(result: Long)
    fun onErrorSavedData(message: String)
}

interface CheckExistDataController{
    fun onSuccessExistData()
    fun onErrorExistData()
}


