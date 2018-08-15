package com.example.henry.forkit.ui.meals

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.henry.forkit.R
import com.example.henry.forkit.domain.Meal
import com.example.henry.forkit.interfaces.AsyncHttpRequest

class MealActivity: AppCompatActivity() {
    private val mealListAdapter: MealListAdapter by lazy { MealListAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals)
        setupList()
        loadData()
    }

    private fun setupList(){
        val mealList = findViewById<RecyclerView>(R.id.meal_list)
        loadData()
        val layoutManager = LinearLayoutManager(this)
        mealList.layoutManager = layoutManager
        mealList.adapter = mealListAdapter
        mealList.setHasFixedSize(true)
    }

    private fun updateDataset(dataset: MutableList<Meal>){
        mealListAdapter.update(dataset)
    }

    private fun loadData(){
        val url = "https://www.themealdb.com/api/json/v1/1/search.php?s=Pork"
        val data = AsyncHttpRequest().execute(url).get()
        updateDataset(data)
    }


}
