package com.example.henry.forkit.ui.meals

import android.graphics.drawable.Drawable
import android.support.v4.content.Loader
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.henry.forkit.R
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.interfaces.ListItemHandler
import com.example.henry.forkit.interfaces.ListItemLongPressHandler
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
        Glide.with(itemView.context)
                .load(meal.strMealThumb)
                .listener(object: RequestListener<Drawable>{
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        return false
                    }
                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        itemView.mealItemProgress.visibility = View.GONE
                        return false
                    }

                })
                .into(itemView.mealItemImage)
    }

    override fun onClick(v: View?) = itemHandler.onItemPress(view, adapterPosition)


    override fun onLongClick(v: View?): Boolean {
        itemLongPressHandler?.onItemLongPress(v, adapterPosition)
        return true
    }

}