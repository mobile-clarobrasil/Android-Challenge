package com.example.henry.forkit.ui.meals

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.henry.forkit.domain.Meal
import com.example.henry.forkit.interfaces.AsyncImageLoader
import com.example.henry.forkit.utils.load
import kotlinx.android.synthetic.main.activity_meals.view.*
import kotlinx.android.synthetic.main.meal_list_item.view.*

class MealViewHolder(view: View): RecyclerView.ViewHolder(view){

    fun bind(meal: Meal){
        itemView.mealItemTitle.text = meal.strMeal
        itemView.mealItemImage.load(meal.strMealThumb)
    }
}