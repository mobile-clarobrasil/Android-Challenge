package com.example.henry.forkit.ui.meals

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.henry.forkit.R
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.interfaces.ListItemHandler
import com.example.henry.forkit.interfaces.ListItemLongPressHandler
import com.example.henry.forkit.utils.load
import kotlinx.android.synthetic.main.meal_list_item.view.*

class MealViewHolder(val view: View, val itemHandler: ListItemHandler, val itemLongPressHandler: ListItemLongPressHandler?):
        RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener{

    init {
        view.setOnClickListener(this)
        view.setOnLongClickListener(this)
    }

    fun bind(meal: Meal){
        itemView.mealItemTitle.text = meal.strMeal
        itemView.mealItemArea.text = "${meal.strArea} ${itemView.resources.getString(R.string.dish)}"
        itemView.mealItemCategory.text = "(${meal.strCategory})"
        Glide.with(itemView.mealItemImage).load(meal.strMealThumb)
        //itemView.mealItemImage.load(meal.strMealThumb)
    }

    override fun onClick(v: View?) = itemHandler.onItemPress(view, adapterPosition)


    override fun onLongClick(v: View?): Boolean {
        itemLongPressHandler?.onItemLongPress(v, adapterPosition)
        return true
    }

}