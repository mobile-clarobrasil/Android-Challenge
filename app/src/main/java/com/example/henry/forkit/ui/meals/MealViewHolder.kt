package com.example.henry.forkit.ui.meals

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.henry.forkit.R
import com.example.henry.forkit.domain.Meal
import com.example.henry.forkit.interfaces.ListItemHandler
import com.example.henry.forkit.utils.load
import kotlinx.android.synthetic.main.meal_list_item.view.*

class MealViewHolder(val view: View, val itemHandler: ListItemHandler): RecyclerView.ViewHolder(view), View.OnClickListener{

    init {
        view.setOnClickListener(this)
    }

    fun bind(meal: Meal){
        itemView.mealItemTitle.text = meal.strMeal
        itemView.mealItemArea.text = "${meal.strArea} ${itemView.resources.getString(R.string.dish)}"
        itemView.mealItemCategory.text = "(${meal.strCategory})"
        itemView.mealItemImage.load(meal.strMealThumb)
    }

    override fun onClick(v: View?) {
        itemHandler.onItemClick(view, adapterPosition)
    }

}