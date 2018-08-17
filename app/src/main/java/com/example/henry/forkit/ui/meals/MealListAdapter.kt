package com.example.henry.forkit.ui.meals

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.henry.forkit.R
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.interfaces.ListItemHandler
import com.example.henry.forkit.interfaces.ListItemLongPressHandler

class MealListAdapter(val itemHandler: ListItemHandler, val itemLongPressHandler: ListItemLongPressHandler? = null): RecyclerView.Adapter<MealViewHolder>(){

    val dataset: MutableList<Meal> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_list_item, parent, false)
        return MealViewHolder(view, itemHandler, itemLongPressHandler)
    }

    override fun getItemCount(): Int = dataset.count()

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) = holder.bind(dataset[position])

    fun update(data: MutableList<Meal>) {
        dataset.clear()
        dataset.addAll(data)
        notifyDataSetChanged()
    }


}