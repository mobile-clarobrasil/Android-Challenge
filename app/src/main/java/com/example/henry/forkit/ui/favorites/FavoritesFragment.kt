package com.example.henry.forkit.ui.favorites

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.henry.forkit.R
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.interfaces.ListItemHandler
import com.example.henry.forkit.interfaces.ListItemLongPressHandler
import com.example.henry.forkit.presentation.MealPresenter
import com.example.henry.forkit.presentation.RetrieveDataController
import com.example.henry.forkit.ui.mealdetails.MealDetailsActivity
import com.example.henry.forkit.ui.meals.MealListAdapter
import kotlinx.android.synthetic.main.favorite_meal_fragment.view.*

class FavoritesFragment: Fragment(), RetrieveDataController, ListItemHandler, ListItemLongPressHandler{

    private val mealPresenter: MealPresenter by lazy { MealPresenter(context, this) }
    private val mealListAdapter: MealListAdapter by lazy { MealListAdapter(this, this) }
    private var mealRecyclerView: RecyclerView? = null
    private val ITEM_MENU_OPTIONS = arrayOf("Open Meal", "Delete Meal")
    private val ITEM_MENU_OPTION_OPEN = 0
    private val ITEM_MENU_OPTION_DELETE = 1
    private val favoriteMealFirstList: MutableList<Meal> = mutableListOf()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.favorite_meal_fragment, container, false)
        mealPresenter.getMeals()
        mealRecyclerView = view.findViewById(R.id.favoriteMealsList)
        setupRecyclerview()

        view.searchFavoriteMeal.addTextChangedListener(object : TextWatcher{
            var search: String? = ""
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                search = s?.toString()
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().trim() != "") {
                    val copy = favoriteMealFirstList
                    val filtered = mutableListOf<Meal>()

                    if(search?.trim()?.length!! < s.toString().length){
                        filtered.addAll(mealListAdapter.dataset.filter {
                            it.strMeal.toLowerCase().contains(s.toString().toLowerCase())
                        }.toMutableList())
                    }else{
                        filtered.addAll(copy.filter {
                            it.strMeal.toLowerCase().contains(s.toString().toLowerCase())
                        }.toMutableList())
                    }
                    mealListAdapter.update(filtered)

                }else{
                    mealListAdapter.update(favoriteMealFirstList)
                }
            }
        })

        return view
    }

    fun newInstance(): FavoritesFragment = FavoritesFragment()

    private fun setupRecyclerview(){
        mealRecyclerView?.layoutManager = GridLayoutManager(context, 2)
        mealRecyclerView?.adapter = mealListAdapter
    }

    override fun onSuccessRetrieveData(data: MutableList<Meal>) {
        favoriteMealFirstList.addAll(data)
        mealListAdapter.update(data)
    }
    override fun onErrorRetrieveData(message: String) {
        TODO("SHOW TO USER THAT HE DOES NOT HAVE FAVORITES YET!")
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemPress(view: View, position: Int) = openDetailActivity(position)

    override fun onItemLongPress(view: View?, position: Int){
        AlertDialog.Builder(context)
                .setItems(ITEM_MENU_OPTIONS) { _: DialogInterface, item: Int ->
                    when(item){
                        ITEM_MENU_OPTION_OPEN -> openDetailActivity(position)
                        ITEM_MENU_OPTION_DELETE -> {
                            mealPresenter.delete(mealListAdapter.dataset[position])
                            mealPresenter.getMeals()
                        }
                    }
                }.show()
    }

    private fun openDetailActivity(whichMeal: Int){
        val detailActivityIntent = Intent(context, MealDetailsActivity::class.java)
        detailActivityIntent.putExtra("meal", mealListAdapter.dataset[whichMeal])
        startActivity(detailActivityIntent)
    }

}