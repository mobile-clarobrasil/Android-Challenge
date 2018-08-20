package com.example.henry.forkit.ui.mealdetails

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.bumptech.glide.Glide
import com.example.henry.forkit.R
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.presentation.MealViewModel
import com.example.henry.forkit.utils.hideOrSetIfEmpty
import kotlinx.android.synthetic.main.activity_meal_details.*

class MealDetailsActivity: AppCompatActivity() { /*InsertDataController, CheckExistDataController*/
    lateinit var meal: Meal
    private val mealViewModel: MealViewModel by lazy{
        ViewModelProviders.of(this).get(MealViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setupDetails()
    }

    private fun setupDetails(){
        with(intent.extras) {
            meal = this?.get("meal") as Meal
            if(mealViewModel.checkIfExist(meal.idMeal) != null){
                favoriteAction.setImageResource(R.drawable.ic_star_white)
            }

            Glide.with(this@MealDetailsActivity).load(meal.strMealThumb).into(mealThumb)
            mealTitle.text = meal.strMeal
            mealArea.text = "${meal.strArea} Dish"
            mealCategory.text = "(${meal.strCategory})"
            mealInstructions.text = meal.strInstructions


            mealIngredient1.hideOrSetIfEmpty(meal.strIngredient1)
            mealMeasure1.hideOrSetIfEmpty(meal.strMeasure1)

            mealIngredient2.hideOrSetIfEmpty(meal.strIngredient2)
            mealMeasure2.hideOrSetIfEmpty(meal.strMeasure2)

            mealIngredient3.hideOrSetIfEmpty(meal.strIngredient3)
            mealMeasure3.hideOrSetIfEmpty(meal.strMeasure3)

            mealIngredient4.hideOrSetIfEmpty(meal.strIngredient4)
            mealMeasure4.hideOrSetIfEmpty(meal.strMeasure4)

            mealIngredient5.hideOrSetIfEmpty(meal.strIngredient5)
            mealMeasure5.hideOrSetIfEmpty(meal.strMeasure5)

            mealIngredient6.hideOrSetIfEmpty(meal.strIngredient6)
            mealMeasure6.hideOrSetIfEmpty(meal.strMeasure6)

            mealIngredient7.hideOrSetIfEmpty(meal.strIngredient7)
            mealMeasure7.hideOrSetIfEmpty(meal.strMeasure7)

            mealIngredient8.hideOrSetIfEmpty(meal.strIngredient8)
            mealMeasure8.hideOrSetIfEmpty(meal.strMeasure8)

            mealIngredient9.hideOrSetIfEmpty(meal.strIngredient9)
            mealMeasure9.hideOrSetIfEmpty(meal.strMeasure9)

            mealIngredient10.hideOrSetIfEmpty(meal.strIngredient10)
            mealMeasure10.hideOrSetIfEmpty(meal.strMeasure10)

            mealIngredient11.hideOrSetIfEmpty(meal.strIngredient11)
            mealMeasure11.hideOrSetIfEmpty(meal.strMeasure11)

            mealIngredient12.hideOrSetIfEmpty(meal.strIngredient12)
            mealMeasure12.hideOrSetIfEmpty(meal.strMeasure12)

            mealIngredient13.hideOrSetIfEmpty(meal.strIngredient13)
            mealMeasure13.hideOrSetIfEmpty(meal.strMeasure13)

            mealIngredient14.hideOrSetIfEmpty(meal.strIngredient14)
            mealMeasure14.hideOrSetIfEmpty(meal.strMeasure14)

            mealIngredient15.hideOrSetIfEmpty(meal.strIngredient15)
            mealMeasure15.hideOrSetIfEmpty(meal.strMeasure15)

            mealIngredient16.hideOrSetIfEmpty(meal.strIngredient16)
            mealMeasure16.hideOrSetIfEmpty(meal.strMeasure16)

            mealIngredient17.hideOrSetIfEmpty(meal.strIngredient17)
            mealMeasure17.hideOrSetIfEmpty(meal.strMeasure17)

            mealIngredient18.hideOrSetIfEmpty(meal.strIngredient18)
            mealMeasure18.hideOrSetIfEmpty(meal.strMeasure18)

            mealIngredient19.hideOrSetIfEmpty(meal.strIngredient19)
            mealMeasure19.hideOrSetIfEmpty(meal.strMeasure19)

            mealIngredient20.hideOrSetIfEmpty(meal.strIngredient20)
            mealMeasure20.hideOrSetIfEmpty(meal.strMeasure20)
        }
    }

    fun makeFavorite(v: View) {
        if(mealViewModel.checkIfExist(meal.idMeal) == null) {
            mealViewModel.save(meal)
            favoriteAction.setImageResource(R.drawable.ic_star_white)
            Snackbar.make(favoriteAction, "Saved in your favorites!", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Ok", {}).show()
        }else{
            Snackbar.make(favoriteAction, "Already saved!", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Ok", {}).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
